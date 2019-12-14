package com.warmachine.errorcenterapi.converter;

import com.warmachine.errorcenterapi.controller.error.request.CreateErrorRequest;
import com.warmachine.errorcenterapi.entity.Error;
import com.warmachine.errorcenterapi.entity.User;

public class ErrorRequestConverter {

    public Error errorFromRequest(CreateErrorRequest createErrorRequest, User user) {
        Error error = new Error();
        error.setUser(user);
        error.setDescription(createErrorRequest.getDetalhes());
        error.setLevel(createErrorRequest.getLevel());
        return error;
    }
}