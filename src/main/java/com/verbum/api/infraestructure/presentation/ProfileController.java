package com.verbum.api.infraestructure.presentation;


import com.verbum.api.core.domain.Profile;
import com.verbum.api.core.useCases.Profile.CreateProfileUseCase;
import com.verbum.api.core.useCases.Profile.GetProfileUseCase;
import com.verbum.api.infraestructure.dtos.Profile.ProfileRequestDto;
import com.verbum.api.infraestructure.dtos.Profile.ProfileResponseDto;
import com.verbum.api.infraestructure.mapper.profile.ProfileDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {

    private final GetProfileUseCase getProfileUseCase;
    private final CreateProfileUseCase createProfileUseCase;
    private final ProfileDtoMapper profileDtoMapper;

    public ProfileController(GetProfileUseCase getProfileUseCase,
                             ProfileDtoMapper profileDtoMapper,
                             CreateProfileUseCase createProfileUseCase) {
        this.getProfileUseCase = getProfileUseCase;
        this.profileDtoMapper = profileDtoMapper;
        this.createProfileUseCase = createProfileUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileResponseDto> getProfile(@PathVariable UUID id) {
        Profile profile = getProfileUseCase.execute(id);
        ProfileResponseDto response = profileDtoMapper.toDto(profile);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ProfileResponseDto> createProfile(@RequestBody ProfileRequestDto profileDto) {
        Profile createprofile = createProfileUseCase.execute(profileDtoMapper.toDomain(profileDto));
        ProfileResponseDto response = profileDtoMapper.toDto(createprofile);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createprofile.id())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }
}
