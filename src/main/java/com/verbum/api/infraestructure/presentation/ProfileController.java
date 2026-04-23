package com.verbum.api.infraestructure.presentation;


import com.verbum.api.core.domain.Profile;
import com.verbum.api.core.useCases.Profile.GetProfileUseCase;
import com.verbum.api.infraestructure.dtos.Profile.ProfileResponseDto;
import com.verbum.api.infraestructure.mapper.profile.ProfileDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {

    private final GetProfileUseCase getProfileUseCase;
    private final ProfileDtoMapper profileDtoMapper;

    public ProfileController(GetProfileUseCase getProfileUseCase,
                             ProfileDtoMapper profileDtoMapper) {
        this.getProfileUseCase = getProfileUseCase;
        this.profileDtoMapper = profileDtoMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileResponseDto> getProfile(@PathVariable UUID id) {
        Profile profile = getProfileUseCase.execute(id);
        ProfileResponseDto response = profileDtoMapper.toDto(profile);
        return ResponseEntity.ok(response);
    }
}
