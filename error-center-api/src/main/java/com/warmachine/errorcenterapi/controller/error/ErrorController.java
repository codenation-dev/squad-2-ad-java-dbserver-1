package com.warmachine.errorcenterapi.controller.error;

import com.warmachine.errorcenterapi.controller.error.request.ErrorRequest;
import com.warmachine.errorcenterapi.controller.error.response.ArchiveErrorResponse;
import com.warmachine.errorcenterapi.controller.error.response.CreateErrorResponse;
import com.warmachine.errorcenterapi.controller.error.response.DeleteErrorResponse;
import com.warmachine.errorcenterapi.controller.error.response.DetailErrorResponse;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.warmachine.errorcenterapi.service.impl.ErrorServiceImpl;

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
	public ResponseEntity<CreateErrorResponse> createError(@RequestBody @NonNull ErrorRequest errorRequest, @RequestBody @NonNull String token) {
		Optional<CreateErrorResponse> response = errorService.createError(errorRequest, token);
		return  ResponseEntity.ok(response.get());
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
