package com.verbum.api.infraestructure.presentation;

import com.verbum.api.core.domain.User;
import com.verbum.api.core.useCases.Auth.RegisterUserUseCase;
import com.verbum.api.infraestructure.dtos.UserDto;
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
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        User createUser = registerUserUseCase.execute(userDtoMapper.toDomain(userDto));
        UserDto responseDto = userDtoMapper.toDto(createUser);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createUser.id())
                .toUri();

        return ResponseEntity.created(location).body(responseDto);
    }


    @GetMapping
    public String hello() {
        return "Hello world";
    }
}
