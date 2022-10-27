package com.financialctl.financialinfo.infrastructure.adapters.output.persistence.mappers;

import com.financialctl.financialinfo.domain.models.User;
import com.financialctl.financialinfo.infrastructure.adapters.output.persistence.entities.UserDB;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDBMapper {
    UserDBMapper INSTANCE = Mappers.getMapper(UserDBMapper.class);

    @Mappings({
            @Mapping(target = "finance.user", ignore = true),
            @Mapping(target = "finance.operations", ignore = true)
    })
    UserDB userToUserDB(final User user);

    @Mappings({
            @Mapping(target = "finance.user", ignore = true),
            @Mapping(target = "finance.operations", ignore = true)
    })
    User userDBToUser(final UserDB userDB);
}
