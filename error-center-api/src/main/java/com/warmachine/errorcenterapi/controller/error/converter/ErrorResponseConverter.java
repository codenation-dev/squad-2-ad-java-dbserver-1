package com.warmachine.errorcenterapi.controller.error.converter;

import com.warmachine.errorcenterapi.controller.error.response.ErrorResponse;
import com.warmachine.errorcenterapi.entity.Error;
import org.springframework.stereotype.Component;

@Component
public class ErrorResponseConverter {

    public static ErrorResponse errorResponseFromEntity(Error error){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setDescription(error.getDescription());
        errorResponse.setUsernameFromUser(error.getUser().getEmail());
        errorResponse.setAmbient(error.getAmbient());
        errorResponse.setLevel(error.getLevel());
        errorResponse.setIpOrigin(error.getIpOrigin());
        if(error.getStatus() == 0) {
            errorResponse.setStatus("Archived");
        }
        else{
            errorResponse.setStatus("Not Archived");
        }
        return errorResponse;
    }
}
