package com.warmachine.errorcenterapi.service;

import java.util.Optional;

import com.warmachine.errorcenterapi.dto.UserLoginRequest;
import com.warmachine.errorcenterapi.dto.UserRecoverPasswordRequest;
import com.warmachine.errorcenterapi.dto.UserRegisterRequest;
import com.warmachine.errorcenterapi.entity.User;

import lombok.NonNull;

public interface UserService {
	
	User save(User user);

	Optional<User> findByEmail(String email);

	//Métodos já existentes
	String login(@NonNull UserLoginRequest userLoginRequest);
	String register(@NonNull UserRegisterRequest userRegisterRequest);
	void recoverPassword(@NonNull UserRecoverPasswordRequest userRecoverPasswordRequest);
	
		
}
