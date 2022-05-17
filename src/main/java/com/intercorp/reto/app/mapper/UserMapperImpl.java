package com.intercorp.reto.app.mapper;

import com.intercorp.reto.app.entity.UserEntity;
import com.intercorp.reto.app.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper{
    @Override
    public UserEntity toEntity(User user) {
        if(user == null){
            return null;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setLastName(user.getLastName());
        userEntity.setAge(user.getAge());
        userEntity.setDateBorn(user.getDateBorn());
        userEntity.setDateDie(user.getDateDie());
        return userEntity;
    }

    @Override
    public User toModel(UserEntity userEntity) {
        if(userEntity == null){
            return null;
        }
        User user = new User();

        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setLastName(userEntity.getLastName());
        user.setAge(userEntity.getAge());
        user.setDateBorn(userEntity.getDateBorn());
        user.setDateDie(userEntity.getDateDie());
        return user;
    }
}
