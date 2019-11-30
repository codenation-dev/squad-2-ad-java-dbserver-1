package com.warmachine.errorcenterapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.warmachine.errorcenterapi.service.impl.ErrorServiceImpl;

@RestController
public class ErrorAPI {
	
	private ErrorServiceImpl errorService;
	
	@Autowired
	public ErrorAPI(ErrorServiceImpl errorService) {
		this.errorService = errorService;
	}

	public void registerError() {
		
	}
	
	public void consultError() {
		
	}
}
