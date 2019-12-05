package com.warmachine.errorcenterapi.controller.user.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

	private Long id;
	@NotNull(message = "Informe email")
	private String email;
	@NotNull(message = "Informe password")
	private String password;
}
