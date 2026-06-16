package com.verbum.api.infraestructure.mapper.user;

import com.verbum.api.core.domain.User;
import com.verbum.api.infraestructure.persistence.entities.UserEntity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

    public User toDomain(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getIsActive(),
                userEntity.getRole(),
                List.of());
    }

    public UserEntity toEntity(User user) {

        UserEntity entity = new UserEntity();
        entity.setId(user.id());
        entity.setEmail(user.email());
        entity.setPassword(user.password());
        entity.setIsActive(user.isActive());
        entity.setRole(user.role());

        return entity;
    }
}
