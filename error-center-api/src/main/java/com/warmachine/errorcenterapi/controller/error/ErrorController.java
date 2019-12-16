package com.warmachine.errorcenterapi.controller.error;

import com.warmachine.errorcenterapi.Messages;
import com.warmachine.errorcenterapi.controller.error.request.ErrorRequest;
import com.warmachine.errorcenterapi.controller.error.response.ErrorMessageResponse;
import com.warmachine.errorcenterapi.controller.error.response.ErrorResponse;
import com.warmachine.errorcenterapi.entity.User;
import com.warmachine.errorcenterapi.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.warmachine.errorcenterapi.service.impl.ErrorServiceImpl;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.security.Principal;

//TODO adicionar exceptions handlers
@RestController
@RequestMapping("/v1/errors")
public class ErrorController {

	private ErrorServiceImpl errorService;

	@Autowired
	public ErrorController(ErrorServiceImpl errorService) {
		this.errorService = errorService;
	}

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Operacao que realiza a criacao de um novo erro.", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ErrorMessageResponse> createError(@Valid @RequestBody ErrorRequest errorRequest, Principal principal) {
		return ResponseEntity.ok(errorService.createError(errorRequest, principal));
	}


	@GetMapping(value = "/detail")
	@ApiOperation(value = "Operacao que lista todos os erros.", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ErrorResponse>> detailAllErrors() {
		return  ResponseEntity.ok(errorService.detailAllErrors());
	}

	@DeleteMapping(value = "/delete/{id}")
	@ApiOperation(value = "Operacao que deleta um erro.", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ErrorMessageResponse> delete(@PathVariable @NonNull Long id){
		return  ResponseEntity.ok(errorService.delete(id));
	}

	@PutMapping(value = "/archive/{id}")
	@ApiOperation(value = "Operacao que arquiva um erro.", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ErrorMessageResponse> archive(@PathVariable @NonNull Long id){
		return  ResponseEntity.ok(errorService.archive(id));
	}
}
