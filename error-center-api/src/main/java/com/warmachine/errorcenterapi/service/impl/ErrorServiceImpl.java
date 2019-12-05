package com.warmachine.errorcenterapi.service.impl;

import com.warmachine.errorcenterapi.controller.error.request.ErrorRequest;
import com.warmachine.errorcenterapi.controller.error.response.ErrorResponse;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Service
public class ErrorServiceImpl {

    public Optional<ErrorResponse> createError(ErrorRequest errorRequest) {
        return null;
    }

}
