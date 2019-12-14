package com.warmachine.errorcenterapi.controller.error;

import com.warmachine.errorcenterapi.controller.error.request.CreateErrorRequest;
import com.warmachine.errorcenterapi.controller.error.response.ArchiveErrorResponse;
import com.warmachine.errorcenterapi.controller.error.response.CreateErrorResponse;
import com.warmachine.errorcenterapi.controller.error.response.DeleteErrorResponse;
import com.warmachine.errorcenterapi.controller.error.response.DetailErrorResponse;
import com.warmachine.errorcenterapi.controller.user.request.UserDto;
import com.warmachine.errorcenterapi.entity.User;
import com.warmachine.errorcenterapi.response.Response;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.warmachine.errorcenterapi.service.impl.ErrorServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/errors")
public class ErrorController {
	
	private ErrorServiceImpl errorService;
	
	@Autowired
	public ErrorController(ErrorServiceImpl errorService) {
		this.errorService = errorService;
	}

	@PostMapping(value = "/create/{token}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Operacao que realiza a criacao de um novo erro.", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<CreateErrorResponse>> createError(@Valid @RequestBody CreateErrorRequest createErrorRequest, @RequestBody @NonNull String token, BindingResult result) {
		Response<CreateErrorResponse> response = new Response<CreateErrorResponse>();
		if(result.hasErrors()) {
			result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		Optional<CreateErrorResponse> optionalCreateErrorResponse = errorService.createError(createErrorRequest, token);
		response.setData(optionalCreateErrorResponse.get());
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping(value = "/detail/{id}/{token}")
	@ApiOperation(value = "Operacao que realiza o detalhamento.", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CreateErrorResponse> detailError(@PathVariable @NonNull String id, @RequestBody @NonNull String token) {
		Optional<CreateErrorResponse> response = errorService.detailError(id, token);
		return  ResponseEntity.ok(response.get());
	}

	@GetMapping(value = "/detail-all/{id}/{token}")
	@ApiOperation(value = "Operacao que uma lista de erros.", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DetailErrorResponse>> detailAllErrors(@PathVariable @NonNull String id, @RequestBody @NonNull String token) {
		Optional<List<DetailErrorResponse>> response = errorService.detailAllErrors(id, token);
		return  ResponseEntity.ok(response.get());
	}

	@GetMapping(value = "/delete/{id}/{token}")
	@ApiOperation(value = "Operacao que deleta o erro.", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DeleteErrorResponse> delete(@PathVariable @NonNull String id, @RequestBody @NonNull String token){
		Optional<DeleteErrorResponse> response = errorService.delete(id, token);
		return  ResponseEntity.ok(response.get());
	}

	@GetMapping(value = "/archive/{id}/{token}")
	@ApiOperation(value = "Operacao que arquiva um erro.", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArchiveErrorResponse> archive(@PathVariable @NonNull String id, @RequestBody @NonNull String token){
		Optional<ArchiveErrorResponse> response = errorService.archive(id, token);
		return  ResponseEntity.ok(response.get());
	}
}
