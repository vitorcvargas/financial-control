package com.financialctl.financialinfo.infrastructure.adapters.input.rest.mappers;

import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.user.UserRequestDTO;
import com.financialctl.financialinfo.infrastructure.adapters.input.rest.dtos.user.UserResponseDTO;
import com.financialctl.financialinfo.domain.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userRequestDtoToUser(final UserRequestDTO userRequestDTO);
    UserResponseDTO userToUserResponseDto(final User user);
}
