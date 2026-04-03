package com.verbum.api.infraestructure.beans;

import com.verbum.api.core.gateway.AuthGateway;
import com.verbum.api.core.gateway.PasswordHasher;
import com.verbum.api.core.gateway.TokenGateway;
import com.verbum.api.core.useCases.Auth.LoginUseCase;
import com.verbum.api.core.useCases.Auth.LoginUseCaseImpl;
import com.verbum.api.core.useCases.Auth.RegisterUserUseCase;
import com.verbum.api.core.useCases.Auth.RegisterUserUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public RegisterUserUseCase createUsersUseCase(AuthGateway authGateway, PasswordHasher passwordHasher) {
        return new RegisterUserUseCaseImpl(authGateway, passwordHasher);
    }

    @Bean
    public LoginUseCase loginUserUseCase(AuthGateway authGateway, TokenGateway tokenGateway) {
        return new LoginUseCaseImpl(tokenGateway,authGateway);
    }

}
