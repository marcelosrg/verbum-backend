package com.verbum.api.core.useCases;

import com.verbum.api.core.domain.User;
import com.verbum.api.core.exceptions.NotFoundException;
import com.verbum.api.core.gateway.UsersGateway;

import java.util.UUID;


public class UpdateUserUseCaseImpl  implements UpdateUserUseCase{

    private  final UsersGateway usersGateway;

    public UpdateUserUseCaseImpl(UsersGateway usersGateway) {
        this.usersGateway= usersGateway;
    }

    @Override
    public User execute(UUID id, User user) {
        if(!usersGateway.existById(id)) {
            throw  new NotFoundException("User not found");
        }
        return usersGateway.updateUser(id,user);
    }

}
