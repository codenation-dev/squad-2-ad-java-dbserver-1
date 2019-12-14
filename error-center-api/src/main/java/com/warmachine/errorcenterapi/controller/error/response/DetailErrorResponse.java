package com.warmachine.errorcenterapi.controller.error.response;

import com.warmachine.errorcenterapi.util.Ambiente;
import com.warmachine.errorcenterapi.util.Level;
import lombok.Data;

@Data
public class DetailErrorResponse {
    private Ambiente ambiente;
    private Level level;
    private String log;
    private String titulo;
    private String detalhes;
    private String coletadoPor;
    private Integer eventos;
}
