package com.warmachine.errorcenterapi.service.impl;

import com.warmachine.errorcenterapi.controller.error.request.CreateErrorRequest;
import com.warmachine.errorcenterapi.controller.error.response.ErrorResponse;
import com.warmachine.errorcenterapi.converter.ErrorRequestConverter;
import com.warmachine.errorcenterapi.entity.Error;
import com.warmachine.errorcenterapi.entity.User;
import com.warmachine.errorcenterapi.mapper.ErrorMapper;
import com.warmachine.errorcenterapi.repository.ErrorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ErrorServiceImpl {

    private ErrorsRepository errorsRepository;
    private ErrorMapper errorMapper;
    private ErrorRequestConverter converter;

    @Autowired
    public ErrorServiceImpl(ErrorsRepository errorsRepository) {
        this.errorsRepository = errorsRepository;
    }

    public void createError(CreateErrorRequest createErrorRequest, User user) {

        errorsRepository.save(converter.errorFromRequest(createErrorRequest, user));

    }

    public ErrorResponse detailError(Long id) {

        Optional<Error> errorOpt = errorsRepository.findById(id);
        ErrorResponse createErrorResponse = null;
        if(errorOpt.isPresent()){
            Error error = errorOpt.get();
            createErrorResponse = new ErrorResponse();
            createErrorResponse.setAmbiente(error.getAmbient());
            createErrorResponse.setColetadoPor(error.getUser().getEmail());
            createErrorResponse.setDetalhes(error.getDescription());
            createErrorResponse.setLevel(error.getLevel());
        }

        return createErrorResponse;
    }

    public void delete(Long id) {
        Optional<Error> errorOpt = errorsRepository.findById(id);
        if(errorOpt.isPresent()) {
            Error error = errorOpt.get() ;
            errorsRepository.delete(error);
        }
    }

    public void archive(Long id) {
        Optional<Error> errorOpt = errorsRepository.findById(id);
        if(errorOpt.isPresent()){
            Error error = errorOpt.get();
            error.setArchive((byte) 0);
        }
    }

    public List<ErrorResponse> detailAllErrors() {
        return errorMapper.map(errorsRepository.findAll());
    }
}
