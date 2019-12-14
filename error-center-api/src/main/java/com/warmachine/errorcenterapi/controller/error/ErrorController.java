package com.warmachine.errorcenterapi.controller.error;

import com.warmachine.errorcenterapi.controller.error.request.CreateErrorRequest;
import com.warmachine.errorcenterapi.controller.error.response.ErrorResponse;
import com.warmachine.errorcenterapi.entity.User;
import com.warmachine.errorcenterapi.response.Response;
import com.warmachine.errorcenterapi.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.warmachine.errorcenterapi.service.impl.ErrorServiceImpl;

import java.security.Principal;

//TODO Arrumar os .get() dos optionals e adicionar excessões
@RestController
@RequestMapping("/v1/errors")
public class ErrorController {

	private ErrorServiceImpl errorService;

	private UserServiceImpl userService;

	@Autowired
	public ErrorController(ErrorServiceImpl errorService) {
		this.errorService = errorService;
	}

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Operacao que realiza a criacao de um novo erro.", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createError(@Valid @RequestBody CreateErrorRequest createErrorRequest, Principal principal, BindingResult result) {
		Response<ErrorResponse> response = new Response<ErrorResponse>();

		if(result.hasErrors()) {
			result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.badRequest().body("Error");
			//TODO Result não está sendo utilizado
		}

		Optional<User> userOpt = userService.findByEmail(((UserDetails)principal).getUsername());

		if(userOpt.isPresent()) {
			User user = userOpt.get();
			errorService.createError(createErrorRequest, user);
			return ResponseEntity.ok("Created Error");
		}
		else{
			return ResponseEntity.badRequest().body("User Not Found");
		}
	}

	@GetMapping(value = "/detail/{id}")
	@ApiOperation(value = "Operacao que realiza o detalhamento.", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ErrorResponse> detailError(@PathVariable @NonNull Long id) {
		ErrorResponse response = errorService.detailError(id);
		return  ResponseEntity.ok(response);
	}

	@GetMapping(value = "/detail")
	@ApiOperation(value = "Operacao que lista todos os erros.", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ErrorResponse>> detailAllErrors() {
		List<ErrorResponse> response = errorService.detailAllErrors();
		return  ResponseEntity.ok(response);
	}

	@DeleteMapping(value = "/delete/{id}")
	@ApiOperation(value = "Operacao que deleta um erro.", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable @NonNull Long id){
		errorService.delete(id);
		return  ResponseEntity.ok("Deleted");
	}

	@PutMapping(value = "/archive/{id}")
	@ApiOperation(value = "Operacao que arquiva um erro.", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> archive(@PathVariable @NonNull Long id){
		errorService.archive(id);
		return  ResponseEntity.ok("String");
	}
}
