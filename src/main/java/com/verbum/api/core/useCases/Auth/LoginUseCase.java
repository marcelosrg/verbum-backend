package com.verbum.api.core.useCases.Auth;

public interface LoginUseCase {
    String execute(String email, String password);
}
