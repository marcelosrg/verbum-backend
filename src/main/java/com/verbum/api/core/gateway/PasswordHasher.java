package com.verbum.api.core.gateway;

public interface PasswordHasher {
    String hashPassord(String rawPassword);
    boolean checkPassword(String rawPassord, String hashedPassword);

}
