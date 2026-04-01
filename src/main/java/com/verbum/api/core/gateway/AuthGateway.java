package com.verbum.api.core.gateway;

import com.verbum.api.core.domain.User;


public interface AuthGateway {
    User createUser(User user);

}
