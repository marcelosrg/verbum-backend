package com.verbum.api.infraestructure.gateway;

import com.verbum.api.core.domain.User;
import com.verbum.api.core.gateway.AuthGateway;
import com.verbum.api.infraestructure.mapper.UserEntityMapper;
import com.verbum.api.infraestructure.persistence.UserEntity;
import com.verbum.api.infraestructure.persistence.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class AuthRepositoryGateway implements AuthGateway {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public AuthRepositoryGateway(UserRepository userRepository,
                                 UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User registerUser(User user) {
        UserEntity userEntity = userRepository.save(userEntityMapper.toEntity(user)); ;
        return userEntityMapper.toDomain(userEntity);
    }

    @Override
    public boolean checkEmail(String email) {
        return userRepository.existsByEmail(email);
    }

}
