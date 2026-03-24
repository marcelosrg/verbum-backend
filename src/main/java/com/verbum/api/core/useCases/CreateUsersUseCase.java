package com.verbum.api.core.useCases;

import com.verbum.api.core.domain.User;

public interface CreateUsersUseCase {
    public User execute(User user);
}
