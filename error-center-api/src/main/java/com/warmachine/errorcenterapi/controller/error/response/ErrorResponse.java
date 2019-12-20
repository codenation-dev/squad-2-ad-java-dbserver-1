package com.warmachine.errorcenterapi.controller.error.response;

import com.warmachine.errorcenterapi.util.Ambiente;
import com.warmachine.errorcenterapi.util.Level;
import lombok.Data;

@Data
public class ErrorResponse {
    private Ambiente ambient;
    private Level level;
    private String description;
    private String usernameFromUser;
    private String status;
    private String ipOrigin;
}
