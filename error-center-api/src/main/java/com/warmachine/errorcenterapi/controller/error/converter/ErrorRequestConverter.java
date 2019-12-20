package com.warmachine.errorcenterapi.controller.error.converter;

import com.warmachine.errorcenterapi.controller.error.request.ErrorRequest;
import com.warmachine.errorcenterapi.entity.Error;
import com.warmachine.errorcenterapi.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ErrorRequestConverter {

    public Error errorFromRequest(ErrorRequest createErrorRequest, User user, String ip) {
        Error error = new Error();
        error.setUser(user);
        error.setDescription(createErrorRequest.getDescription());
        error.setLevel(createErrorRequest.getLevel());
        error.setIpOrigin(ip);
        error.setAmbient(createErrorRequest.getAmbient());
        return error;
    }


}
