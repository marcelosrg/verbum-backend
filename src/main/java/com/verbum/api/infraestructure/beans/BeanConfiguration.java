package com.verbum.api.infraestructure.beans;

import com.verbum.api.core.gateway.AuthGateway;
import com.verbum.api.core.gateway.PasswordHasher;
import com.verbum.api.core.useCases.Auth.RegisterUserUseCase;
import com.verbum.api.core.useCases.Auth.RegisterUserUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BeanConfiguration {

    @Bean
    public RegisterUserUseCase createUsersUseCase(AuthGateway authGateway, PasswordHasher passwordHasher) {
        return new RegisterUserUseCaseImpl(authGateway, passwordHasher);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
