package com.warmachine.errorcenterapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warmachine.errorcenterapi.dto.UserLoginRequest;
import com.warmachine.errorcenterapi.dto.UserRecoverPasswordRequest;
import com.warmachine.errorcenterapi.dto.UserRegisterRequest;
import com.warmachine.errorcenterapi.entity.User;
import com.warmachine.errorcenterapi.repository.UserRepository;
import com.warmachine.errorcenterapi.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User register(User user) {
		return userRepository.save(user);
	}

	
	
	
	public String login(UserLoginRequest userLoginRequest) {
		return "1234";
	}

	public String register(UserRegisterRequest userRegisterRequest) {
		return "1234";
	}

	public void recoverPassword(UserRecoverPasswordRequest userRecoverPasswordRequest) {}



}
