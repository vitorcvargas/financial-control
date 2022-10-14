package com.financialctl.financialinfo.mappers;

import com.financialctl.financialinfo.domain.models.User;
import com.financialctl.financialinfo.dtos.UserPostDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userPostDtoToUser(final UserPostDto userPostDto);
}