package com.verbum.api.infraestructure.gateway;

import com.verbum.api.core.domain.User;
import com.verbum.api.core.gateway.UsersGateway;
import com.verbum.api.infraestructure.mapper.UserEntityMapper;
import com.verbum.api.infraestructure.persistence.UserEntity;
import com.verbum.api.infraestructure.persistence.UserRepository;

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
}
