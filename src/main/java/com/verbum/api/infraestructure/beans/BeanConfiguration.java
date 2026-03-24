package com.verbum.api.infraestructure.beans;

import com.verbum.api.core.gateway.UsersGateway;
import com.verbum.api.core.useCases.CreateUsersUseCase;
import com.verbum.api.core.useCases.CreateUsersUseCaseImpl;
import org.springframework.context.annotation.Bean;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateUsersUseCase createUsersUseCase(UsersGateway usersGateway) {
        return new CreateUsersUseCaseImpl(UsersGateway);
    }
}
