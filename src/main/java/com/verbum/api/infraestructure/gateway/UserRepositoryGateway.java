package com.verbum.api.infraestructure.gateway;

import com.verbum.api.core.domain.User;
import com.verbum.api.core.gateway.AuthGateway;
import com.verbum.api.infraestructure.mapper.UserEntityMapper;
import com.verbum.api.infraestructure.persistence.UserEntity;
import com.verbum.api.infraestructure.persistence.UserRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserRepositoryGateway implements AuthGateway {

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
