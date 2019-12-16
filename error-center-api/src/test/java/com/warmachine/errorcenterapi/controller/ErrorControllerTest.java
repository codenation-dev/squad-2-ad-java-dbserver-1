package com.warmachine.errorcenterapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.warmachine.errorcenterapi.ContextsLoads;
import com.warmachine.errorcenterapi.Messages;
import com.warmachine.errorcenterapi.base.controller.BaseControllerTest;
import com.warmachine.errorcenterapi.controller.error.ErrorController;
import com.warmachine.errorcenterapi.controller.error.request.ErrorRequest;
import com.warmachine.errorcenterapi.controller.error.response.ErrorMessageResponse;
import com.warmachine.errorcenterapi.service.impl.ErrorServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.security.Principal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ErrorController.class)
@ActiveProfiles("test")
@Import(ContextsLoads.class)
public class ErrorControllerTest extends BaseControllerTest {

    private static final String SESSION_URL = "/v1/errors/create";

    private ObjectMapper mapper;

    @MockBean
    private ErrorServiceImpl errorService;

    @Autowired
    protected MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mapper = new ObjectMapper();
    }

    @Test
    public void deveRetornarSucessoQuandoReceboUmErroCorretoParaSalvar() throws Exception {
        final JsonNode requestJson = loadAsJsonFromResource("json/create-error-request.json");
        final String expectedResponse = loadResourceAsString("json/create-error-response.json");

        final ErrorMessageResponse response = new ErrorMessageResponse(Messages.ERROR_CREATED);

        when(errorService.createError(any(ErrorRequest.class), any(Principal.class))).thenReturn(response);

        mockMvc.perform(post(SESSION_URL)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(requestJson)))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponse));

    }
}
