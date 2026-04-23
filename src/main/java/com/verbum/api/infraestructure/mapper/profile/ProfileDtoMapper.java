package com.verbum.api.infraestructure.mapper.profile;

import com.verbum.api.core.domain.Profile;

import com.verbum.api.infraestructure.dtos.Profile.ProfileRequestDto;
import com.verbum.api.infraestructure.dtos.Profile.ProfileResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ProfileDtoMapper {

    public Profile toDomain(ProfileRequestDto dto){
        return new Profile(
                dto.id(),
                dto.username(),
                dto.biography(),
                dto.imageUrl(),
                dto.userId()

        );
    }

    public ProfileResponseDto toDto (Profile profile){
        return new ProfileResponseDto(
                profile.id(),
                profile.username(),
                profile.biography(),
                profile.imageUrl()
        );
    }
}
