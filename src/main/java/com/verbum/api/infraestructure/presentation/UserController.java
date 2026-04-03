package com.verbum.api.infraestructure.presentation;

import com.verbum.api.core.domain.User;
import com.verbum.api.core.useCases.Auth.RegisterUserUseCase;
import com.verbum.api.infraestructure.dtos.AuthRequestDto;
import com.verbum.api.infraestructure.dtos.AuthResponseDto;
import com.verbum.api.infraestructure.mapper.UserDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {
    private final RegisterUserUseCase registerUserUseCase;
    private final UserDtoMapper userDtoMapper;
    public UserController(RegisterUserUseCase registerUserUseCase,
                          UserDtoMapper userDtoMapper) {
        this.registerUserUseCase = registerUserUseCase;
        this.userDtoMapper = userDtoMapper;
    }
    @PostMapping()
    public ResponseEntity<AuthResponseDto> createUser(@RequestBody AuthRequestDto authRequestDto) {
        User createUser = registerUserUseCase.execute(userDtoMapper.toDomain(authRequestDto));
        AuthResponseDto responseDto = userDtoMapper.toDto(createUser);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createUser.id())
                .toUri();

        return ResponseEntity.created(location).body(responseDto);
    }

}
