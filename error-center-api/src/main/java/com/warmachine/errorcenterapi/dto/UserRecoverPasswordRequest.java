package com.warmachine.errorcenterapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRecoverPasswordRequest {
	private String email;
}
