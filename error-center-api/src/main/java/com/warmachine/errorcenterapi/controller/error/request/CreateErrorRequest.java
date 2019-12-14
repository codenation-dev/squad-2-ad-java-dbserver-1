package com.warmachine.errorcenterapi.controller.error.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.warmachine.errorcenterapi.util.Ambiente;
import com.warmachine.errorcenterapi.util.Level;
import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateErrorRequest {
    @NotNull(message = "Informe o Ambiente")
    private Ambiente ambiente;
    @NotNull(message = "Informe o Level")
    private Level level;
    @NotNull(message = "Informe os detalhes")
    private String detalhes;
    @NotNull(message = "Informe o Coletato por")
    private String coletadoPor;
}
