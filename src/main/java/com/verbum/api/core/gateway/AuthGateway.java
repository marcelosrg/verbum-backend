package com.verbum.api.core.gateway;

import com.verbum.api.core.domain.User;


public interface AuthGateway {
    User registerUser(User user);
    User authenticate(String email, String password);
    boolean checkEmail(String email);

}
