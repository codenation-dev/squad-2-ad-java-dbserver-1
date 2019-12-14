package com.warmachine.errorcenterapi.service.impl;

import com.warmachine.errorcenterapi.controller.error.request.CreateErrorRequest;
import com.warmachine.errorcenterapi.controller.error.response.ArchiveErrorResponse;
import com.warmachine.errorcenterapi.controller.error.response.CreateErrorResponse;
import com.warmachine.errorcenterapi.controller.error.response.DeleteErrorResponse;
import com.warmachine.errorcenterapi.controller.error.response.DetailErrorResponse;
import com.warmachine.errorcenterapi.repository.ErrorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ErrorServiceImpl {

    @Autowired
    private ErrorsRepository errorsRepository;

    public Optional<CreateErrorResponse> createError(CreateErrorRequest createErrorRequest, String token) {
        return null;
    }

    public Optional<CreateErrorResponse> detailError(String id, String token) {
        return null;
    }

    public Optional<DeleteErrorResponse> delete(String id, String token) {
        return null;
    }

    public Optional<ArchiveErrorResponse> archive(String id, String token) {
        return null;
    }

    public Optional<List<DetailErrorResponse>> detailAllErrors(String id, String token) {
        return null;
    }
}
