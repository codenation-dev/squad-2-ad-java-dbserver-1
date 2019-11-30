package com.warmachine.errorcenterapi.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRecoverPasswordRequest {
	private String email;
}
