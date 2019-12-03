package com.warmachine.errorcenterapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warmachine.errorcenterapi.dto.UserLoginRequest;
import com.warmachine.errorcenterapi.dto.UserRecoverPasswordRequest;
import com.warmachine.errorcenterapi.dto.UserRegisterRequest;
import com.warmachine.errorcenterapi.service.UserService;

import io.swagger.annotations.ApiOperation;
import lombok.NonNull;

@RestController
@RequestMapping(value = "/v2", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserAPI {

	private UserService userService;

	@Autowired
	public UserAPI(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(value = "/login")
	@ApiOperation(value = "Operacao que realiza o login e retorna o token do usuario.")
	public ResponseEntity<Object> login(@RequestBody @NonNull UserLoginRequest userLoginRequest) {
		String token = userService.login(userLoginRequest);

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		headers.setBearerAuth(token);

		return new ResponseEntity<>(headers, HttpStatus.OK);
	}
 
	@PostMapping(value = "/register")
	@ApiOperation(value = "Operacao que realiza o registro de um novo usuario.")
	public ResponseEntity<Object> register(@RequestBody @NonNull UserRegisterRequest userRegisterRequest) {
		String token = userService.register(userRegisterRequest);

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		headers.setBearerAuth(token);

		return new ResponseEntity<>(headers, HttpStatus.OK);
	}
	@PostMapping(value = "/recover-password")
	@ApiOperation(value = "Operacao que realiza a definicao da senha do usuario.")
	public void requestTokenUser(@RequestBody @NonNull UserRecoverPasswordRequest userRecoverPasswordRequest) {
		userService.recoverPassword(userRecoverPasswordRequest);
	}

}
