package com.warmachine.errorcenterapi.service;

import org.springframework.stereotype.Service;

import com.warmachine.errorcenterapi.dto.user.UserLoginRequest;
import com.warmachine.errorcenterapi.dto.user.UserRecoverPasswordRequest;
import com.warmachine.errorcenterapi.dto.user.UserRegisterRequest;

@Service
public class UserService {

	public String login(UserLoginRequest userLoginRequest) {
		
		return "1234";
	}

	public String register(UserRegisterRequest userRegisterRequest) {
		
		return "1234";
	}

	public void recoverPassword(UserRecoverPasswordRequest userRecoverPasswordRequest) {
		
	}

}
