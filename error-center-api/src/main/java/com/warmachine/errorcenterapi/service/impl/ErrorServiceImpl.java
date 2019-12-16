package com.warmachine.errorcenterapi.service.impl;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import com.warmachine.errorcenterapi.Messages;
import com.warmachine.errorcenterapi.controller.error.request.ErrorRequest;
import com.warmachine.errorcenterapi.controller.error.response.ErrorMessageResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.warmachine.errorcenterapi.controller.error.response.ErrorResponse;
import com.warmachine.errorcenterapi.controller.error.converter.ErrorRequestConverter;
import com.warmachine.errorcenterapi.entity.Error;
import com.warmachine.errorcenterapi.entity.User;
import com.warmachine.errorcenterapi.mapper.ErrorMapper;
import com.warmachine.errorcenterapi.repository.ErrorsRepository;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class ErrorServiceImpl {

    private ErrorsRepository errorsRepository;
    private ErrorMapper errorMapper;
    private ErrorRequestConverter converter;
    private UserServiceImpl userService;

    public ErrorServiceImpl(ErrorsRepository errorsRepository, UserServiceImpl userService) {
        this.errorsRepository = errorsRepository;
        this.userService = userService;
    }


    public ErrorMessageResponse createError(ErrorRequest createErrorRequest, Principal principal) {
        Optional<User> userOpt = userService.findByEmail(((UserDetails)principal).getUsername());

        if(userOpt.isPresent()){
            User user = userOpt.get();
            String ip = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                    .getRequest().getRemoteAddr();
            errorsRepository.save(converter.errorFromRequest(createErrorRequest, user, ip));
            return new ErrorMessageResponse(Messages.ERROR_CREATED);
        }

       throw new IllegalArgumentException(Messages.UNABLE_TO_FIND_USER);

    }

    public ErrorMessageResponse delete(Long id) {
        Optional<Error> errorOpt = errorsRepository.findById(id);

        if(errorOpt.isPresent()) {
            Error error = errorOpt.get() ;
            errorsRepository.delete(error);
            return new ErrorMessageResponse(Messages.ERROR_DELETED);
        }

        throw new IllegalArgumentException(Messages.UNABLE_TO_FIND_ERROR);
    }

    public ErrorMessageResponse archive(Long id){
        Optional<Error> errorOpt = errorsRepository.findById(id);

        if(errorOpt.isPresent()){
            Error error = errorOpt.get();
            error.setArchive((byte) 0);
            errorsRepository.save(error);
            return new ErrorMessageResponse(Messages.ERROR_ARCHIVED);
        }

        throw new IllegalAccessException(Messages.UNABLE_TO_FIND_ERROR);
    }

    public List<ErrorResponse> detailAllErrors() {
        return errorMapper.map(errorsRepository.findAll());
    }
}
