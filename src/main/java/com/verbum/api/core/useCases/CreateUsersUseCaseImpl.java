package com.verbum.api.core.useCases;

import com.verbum.api.core.domain.User;
import com.verbum.api.core.gateway.UsersGateway;

public class CreateUsersUseCaseImpl implements CreateUsersUseCase {

    private UsersGateway usersGateway;

    public CreateUsersUseCaseImpl(UsersGateway usersGateway) {
        this.usersGateway = usersGateway;
    }
    @Override
    public User execute(User user) {
        return usersGateway.createUser(user);
    }
}
