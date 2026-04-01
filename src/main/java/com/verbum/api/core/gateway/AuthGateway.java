package com.verbum.api.core.gateway;

import com.verbum.api.core.domain.User;


public interface AuthGateway {
    User registerUser(User user);

    boolean checkEmail(String email);

}
