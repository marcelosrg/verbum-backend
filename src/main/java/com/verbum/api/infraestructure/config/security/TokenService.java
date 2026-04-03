package com.verbum.api.infraestructure.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.verbum.api.core.domain.User;
import com.verbum.api.core.enums.Role;
import com.verbum.api.core.gateway.TokenGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Component
public class TokenService implements TokenGateway {

    @Value("${api.security.secret}")
    private String secret;

    @Override
    public String generateToken(User user) {

        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withSubject(user.email())
                .withClaim("id", user.id().toString())
                .withClaim("role", user.role().name())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .withIssuer("Api - Verbum")
                .sign(algorithm);
    }

    public Optional<JWTUserData> validateToken(String token){

        try {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        DecodedJWT jwt  = JWT.require(algorithm)
                .withIssuer("Api - Verbum")
                .build()
                .verify(token);

        return  Optional.of(
                        JWTUserData
                                .builder()
                                .email(jwt.getSubject())
                                .id(UUID.fromString(jwt.getClaim("id").asString()))
                                .role(Role.valueOf(jwt.getClaim("role").asString()))
                                .build()
                );
        }catch (JWTVerificationException e){
            return Optional.empty();

        }
    }
}