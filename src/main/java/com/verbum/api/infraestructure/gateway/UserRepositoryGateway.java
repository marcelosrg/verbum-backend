package com.verbum.api.infraestructure.gateway;

import com.verbum.api.core.domain.User;
import com.verbum.api.core.gateway.UsersGateway;
import com.verbum.api.infraestructure.mapper.UserEntityMapper;
import com.verbum.api.infraestructure.persistence.UserEntity;
import com.verbum.api.infraestructure.persistence.UserRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserRepositoryGateway implements UsersGateway {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryGateway(UserRepository userRepository,
                                 UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User createUser(User user) {
        UserEntity userEntity = userRepository.save(userEntityMapper.toEntity(user)); ;
        return userEntityMapper.toDomain(userEntity);
    }

    @Override
    public User updateUser(UUID id, User user) {
        return userEntityMapper.toDomain(userRepository.save(userEntityMapper.toEntity(user)));
    }

    @Override
    public Boolean existById(UUID id) {
        return  userRepository.existsById(id) ;
    }

}
