package com.verbum.api.core.gateway;

import com.verbum.api.core.domain.User;

import java.util.UUID;

public interface UsersGateway {
    User createUser(User user);

    User updateUser(UUID id, User user);

    Boolean existById(UUID id);
}
