package com.verbum.api.infraestructure.gateway;

import com.verbum.api.core.domain.User;
import com.verbum.api.core.gateway.AuthGateway;
import com.verbum.api.infraestructure.mapper.user.UserEntityMapper;
import com.verbum.api.infraestructure.persistence.entities.UserEntity;
import com.verbum.api.infraestructure.persistence.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class AuthRepositoryGateway implements AuthGateway  {


    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final AuthenticationManager authenticationManager;


    public AuthRepositoryGateway(UserRepository userRepository,
                                 UserEntityMapper userEntityMapper,
                                AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
        this.authenticationManager = authenticationManager;
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

    @Override
    public User authenticate(String email, String password) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(email, password);
        Authentication auth = authenticationManager.authenticate(token);
        UserEntity userEntity = (UserEntity) auth.getPrincipal();
        return userEntityMapper.toDomain(userEntity);
    }

}
