package com.warmachine.errorcenterapi.controller.error.response;

import com.warmachine.errorcenterapi.util.Ambiente;
import com.warmachine.errorcenterapi.util.Level;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class ErrorResponse {
    private Ambiente ambient;
    private Level level;
    private String description;
    private String usernameFromUser;
    private String status;
    private String ipOrigin;
}
