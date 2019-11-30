package com.warmachine.errorcenterapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginRequest {
	private String email;
	private String password;
}
