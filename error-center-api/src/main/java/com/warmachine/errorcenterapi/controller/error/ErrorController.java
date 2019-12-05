package com.warmachine.errorcenterapi.controller.error;

import com.warmachine.errorcenterapi.controller.error.request.ErrorRequest;
import com.warmachine.errorcenterapi.controller.error.response.ErrorResponse;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warmachine.errorcenterapi.service.impl.ErrorServiceImpl;

import java.util.Optional;

@RestController
@RequestMapping("/v1/error")
public class ErrorController {
	
	private ErrorServiceImpl errorService;
	
	@Autowired
	public ErrorController(ErrorServiceImpl errorService) {
		this.errorService = errorService;
	}

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Operacao que realiza a criacao de um novo erro.", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ErrorResponse> createError(@RequestBody @NonNull ErrorRequest errorRequest) {
		Optional<ErrorResponse> response = errorService.createError(errorRequest);
		return  ResponseEntity.ok(response.get());
	}
	
	public void consultError() {
		
	}
}
