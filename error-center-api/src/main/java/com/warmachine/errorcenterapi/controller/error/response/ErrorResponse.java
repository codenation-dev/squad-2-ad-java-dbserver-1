package com.warmachine.errorcenterapi.controller.error.response;

import com.warmachine.errorcenterapi.util.Ambiente;
import com.warmachine.errorcenterapi.util.Level;
import lombok.Data;

@Data
public class ErrorResponse {
    private Ambiente ambiente;
    private Level level;
    private String detalhes;
    private String coletadoPor;
}
