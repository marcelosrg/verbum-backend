package com.verbum.api.infraestructure.beans;

import com.verbum.api.core.gateway.AuthGateway;
import com.verbum.api.core.gateway.PasswordHasher;
import com.verbum.api.core.gateway.ProfileGateway;
import com.verbum.api.core.gateway.TokenGateway;
import com.verbum.api.core.useCases.Auth.LoginUseCase;
import com.verbum.api.core.useCases.Auth.LoginUseCaseImpl;
import com.verbum.api.core.useCases.Auth.RegisterUserUseCase;
import com.verbum.api.core.useCases.Auth.RegisterUserUseCaseImpl;
import com.verbum.api.core.useCases.Profile.CreateProfileUseCase;
import com.verbum.api.core.useCases.Profile.CreateProfileUseCaseImpl;
import com.verbum.api.core.useCases.Profile.GetProfileUseCase;
import com.verbum.api.core.useCases.Profile.GetProfileUseCaseImpl;
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

    @Bean
    public GetProfileUseCase getProfileUseCase(ProfileGateway profileGateway) {
        return new GetProfileUseCaseImpl(profileGateway);
    }

    @Bean
    public CreateProfileUseCase createProfileUseCase(ProfileGateway profileGateway) {
        return new CreateProfileUseCaseImpl(profileGateway);
    }


}
