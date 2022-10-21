package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.mappers;

import com.financialctl.financialinfo.domain.models.User;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entity.UserDB;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDBMapper {
    UserDBMapper INSTANCE = Mappers.getMapper(UserDBMapper.class);

    UserDB userToUserDB(final User user);

    User userDBToUser(final UserDB userDB);
}
