package com.verbum.api.core.useCases.Auth;

import com.verbum.api.core.domain.User;
import com.verbum.api.core.gateway.AuthGateway;
import com.verbum.api.core.gateway.TokenGateway;

public class LoginUseCaseImpl implements LoginUseCase {


    private final TokenGateway tokenGateway;
    private final AuthGateway authGateway;

    public LoginUseCaseImpl( TokenGateway tokenGateway,
                             AuthGateway authGateway) {

        this.tokenGateway = tokenGateway;
        this.authGateway = authGateway;
    }

    @Override
    public String execute(String email, String password) {
        User user = authGateway.authenticate(email, password);
        return tokenGateway.generateToken(user);
    }
}