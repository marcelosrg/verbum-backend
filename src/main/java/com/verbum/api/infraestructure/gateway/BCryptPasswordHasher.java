package com.verbum.api.infraestructure.gateway;

import com.verbum.api.core.gateway.PasswordHasher;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class BCryptPasswordHasher implements PasswordHasher {

    private final PasswordEncoder passwordEncoder;

    public BCryptPasswordHasher(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public String hashPassord(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    @Override
    public boolean checkPassword(String rawPassword, String hashedPassword) {
        return passwordEncoder.matches(rawPassword, hashedPassword);
    }
}
