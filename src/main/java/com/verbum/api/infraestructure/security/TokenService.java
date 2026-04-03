package com.verbum.api.infraestructure.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.verbum.api.core.domain.User;
import com.verbum.api.core.gateway.TokenGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TokenService implements TokenGateway {

    @Value("${api.security.secret}")
    private String secret;

    @Override
    public String generateToken(User user) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withSubject(user.email())
                .withClaim("email", user.email())
                .withClaim("role", user.role().name())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .withIssuer("Api - Verbum")
                .sign(algorithm);
    }
}