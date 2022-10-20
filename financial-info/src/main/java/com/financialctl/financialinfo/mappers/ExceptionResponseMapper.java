package com.financialctl.financialinfo.mappers;

import com.financialctl.financialinfo.exceptions.ExceptionResponse;
import com.financialctl.financialinfo.exceptions.GlobalException;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExceptionResponseMapper {
    ExceptionResponseMapper INSTANCE = Mappers.getMapper(ExceptionResponseMapper.class);

    ExceptionResponse globalExceptionToExceptionResponse(final GlobalException ex);
}
