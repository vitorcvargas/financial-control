package com.financialctl.financialinfo.infrastructure.adapters.input.rest.mappers;

import com.financialctl.financialinfo.infrastructure.adapters.output.exceptions.ExceptionResponse;
import com.financialctl.financialinfo.infrastructure.adapters.output.exceptions.GlobalException;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExceptionResponseMapper {
    ExceptionResponseMapper INSTANCE = Mappers.getMapper(ExceptionResponseMapper.class);

    ExceptionResponse globalExceptionToExceptionResponse(final GlobalException ex);
}
