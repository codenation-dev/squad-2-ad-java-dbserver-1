package com.warmachine.errorcenterapi.controller.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.warmachine.errorcenterapi.service.ErrorService;

@RestController
public class ErrorAPI {
	
	private ErrorService errorService;
	
	@Autowired
	public ErrorAPI(ErrorService errorService) {
		this.errorService = errorService;
	}

	public void registerError() {
		
	}
	
	public void consultError() {
		
	}
}
