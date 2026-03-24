package com.verbum.api.infraestructure.mapper;

import com.verbum.api.core.domain.User;
import com.verbum.api.infraestructure.persistence.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

    public User toDomain(UserEntity userEntity){
        return new User(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getIsActive(),
                userEntity.getRole()
        );
    }

    public UserEntity toEntity (User user){
        return new UserEntity(
                user.id(),
                user.email(),
                user.password(),
                user.isActive(),
                user.role()
        );
    }
}
