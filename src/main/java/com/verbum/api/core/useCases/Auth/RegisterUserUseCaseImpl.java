package com.verbum.api.core.useCases.Auth;

import com.verbum.api.core.domain.User;
import com.verbum.api.core.enums.Role;
import com.verbum.api.core.exceptions.DuplicateException;
import com.verbum.api.core.gateway.AuthGateway;
import com.verbum.api.core.gateway.PasswordHasher;

public class RegisterUserUseCaseImpl implements RegisterUserUseCase {

    private final AuthGateway authGateway;
    private final PasswordHasher passwordHasher;

    public RegisterUserUseCaseImpl(AuthGateway authGateway,
                                   PasswordHasher passwordHasher) {
        this.authGateway = authGateway;
        this.passwordHasher = passwordHasher;
    }


    @Override
    public User execute(User user) {

        if(authGateway.checkEmail(user.email())){
            throw new DuplicateException("O email ja existe!");
        }

        String hashedPassword = passwordHasher.hashPassord(user.password());

        User newUser = new User(
                user.id(),
                user.email(),
                hashedPassword,
                true,
                Role.USER
        );

        return authGateway.registerUser(newUser);
    }
}
