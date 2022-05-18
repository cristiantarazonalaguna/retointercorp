package com.intercorp.reto.app.mapper;

import com.intercorp.reto.app.entity.UserEntity;
import com.intercorp.reto.app.models.User;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toEntity(User user);
    User toModel(UserEntity userEntity);
}
