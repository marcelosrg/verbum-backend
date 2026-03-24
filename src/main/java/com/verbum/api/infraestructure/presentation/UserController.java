package com.verbum.api.infraestructure.presentation;

import com.verbum.api.core.domain.User;
import com.verbum.api.core.useCases.CreateUsersUseCase;
import com.verbum.api.infraestructure.dtos.UserDto;
import com.verbum.api.infraestructure.mapper.UserDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(name = "api/v1/users")
public class UserController {
    private final CreateUsersUseCase createUsersUseCase;
    private final UserDtoMapper userDtoMapper;

    @Autowired
    public UserController(CreateUsersUseCase createUsersUseCase,
                          UserDtoMapper userDtoMapper) {
        this.createUsersUseCase = createUsersUseCase;
        this.userDtoMapper = userDtoMapper;
    }
    @PostMapping("create-user")
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
}
