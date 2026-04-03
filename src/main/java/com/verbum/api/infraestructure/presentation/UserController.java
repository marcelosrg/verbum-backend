package com.verbum.api.infraestructure.presentation;

import com.verbum.api.core.domain.User;
import com.verbum.api.core.useCases.Auth.LoginUseCase;
import com.verbum.api.core.useCases.Auth.RegisterUserUseCase;
import com.verbum.api.infraestructure.dtos.AuthRequestDto;
import com.verbum.api.infraestructure.dtos.AuthResponseDto;
import com.verbum.api.infraestructure.dtos.LoginResponse;
import com.verbum.api.infraestructure.mapper.UserDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    private final RegisterUserUseCase registerUserUseCase;
    private final LoginUseCase loginUseCase;
    private final UserDtoMapper userDtoMapper;

    public UserController(RegisterUserUseCase registerUserUseCase,
                          LoginUseCase loginUseCase,
                          UserDtoMapper userDtoMapper) {
        this.registerUserUseCase = registerUserUseCase;
        this.loginUseCase = loginUseCase;
        this.userDtoMapper = userDtoMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDto> createUser(@RequestBody AuthRequestDto authRequestDto) {
        User createdUser = registerUserUseCase.execute(userDtoMapper.toDomain(authRequestDto));
        AuthResponseDto responseDto = userDtoMapper.toDto(createdUser);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.id())
                .toUri();
        return ResponseEntity.created(location).body(responseDto);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody AuthRequestDto authRequestDto) {
        String token = loginUseCase.execute(authRequestDto.email(), authRequestDto.password());
        return ResponseEntity.ok(new LoginResponse(token));
    }
}