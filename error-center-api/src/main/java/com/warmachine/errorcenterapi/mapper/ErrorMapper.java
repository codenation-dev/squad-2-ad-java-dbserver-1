package com.warmachine.errorcenterapi.mapper;

import com.warmachine.errorcenterapi.controller.error.response.ErrorResponse;
import com.warmachine.errorcenterapi.entity.Error;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ErrorMapper {

    @Mappings({
            @Mapping(source = "ambient", target = "ambient"),
            @Mapping(source = "level", target = "level"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "user.email", target = "collectedBy"),
    })

    List<ErrorResponse> map(List<Error> error);
}
