package com.verbum.api.infraestructure.beans;

import com.verbum.api.core.gateway.UsersGateway;
import com.verbum.api.core.useCases.CreateUsersUseCase;
import com.verbum.api.core.useCases.CreateUsersUseCaseImpl;
import com.verbum.api.core.useCases.UpdateUserUseCase;
import com.verbum.api.core.useCases.UpdateUserUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateUsersUseCase createUsersUseCase(UsersGateway usersGateway) {
        return new CreateUsersUseCaseImpl(usersGateway);
    }
    @Bean
    public UpdateUserUseCase updateUserUseCase(UsersGateway usersGateway) {
        return new UpdateUserUseCaseImpl(usersGateway);
    }
}
