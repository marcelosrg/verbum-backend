package com.verbum.api.infraestructure.presentation;

import com.verbum.api.core.domain.User;
import com.verbum.api.core.useCases.CreateUsersUseCase;
import com.verbum.api.core.useCases.UpdateUserUseCase;
import com.verbum.api.infraestructure.dtos.UserDto;
import com.verbum.api.infraestructure.mapper.UserDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final CreateUsersUseCase createUsersUseCase;
    private final UserDtoMapper userDtoMapper;
    private final UpdateUserUseCase updateUserUseCase;
    public UserController(CreateUsersUseCase createUsersUseCase,
                          UserDtoMapper userDtoMapper,
                           UpdateUserUseCase updateUserUseCase) {
        this.createUsersUseCase = createUsersUseCase;
        this.userDtoMapper = userDtoMapper;
        this.updateUserUseCase = updateUserUseCase;
    }
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        User createUser = createUsersUseCase.execute(userDtoMapper.toDomain(userDto));
        UserDto responseDto = userDtoMapper.toDto(createUser);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createUser.id())
                .toUri();

        return ResponseEntity.created(location).body(responseDto);
    }

    @PutMapping("{id}")
    public  ResponseEntity<UserDto> updateUser(@PathVariable("id") UUID id,  @RequestBody  UserDto userDto) {
        User userUpdated = updateUserUseCase.execute(id, userDtoMapper.toDomain(userDto));
        return ResponseEntity.ok().body(userDtoMapper.toDto(userUpdated));
    }


    @GetMapping
    public String hello() {
        return "Hello world";
    }
}
