package com.warmachine.errorcenterapi.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequest {
	private String name;
	private String email;
	private String password;
}
