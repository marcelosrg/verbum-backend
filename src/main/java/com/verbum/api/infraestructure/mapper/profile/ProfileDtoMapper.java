package com.verbum.api.infraestructure.mapper.profile;

import com.verbum.api.core.domain.Profile;

import com.verbum.api.infraestructure.dtos.Profile.ProfileRequestDto;
import com.verbum.api.infraestructure.dtos.Profile.ProfileResponseDto;

public class ProfileDtoMapper {

    public Profile toDomain(ProfileRequestDto dto){
        return new Profile(
                dto.id(),
                dto.userName(),
                dto.biography(),
                dto.userId()

        );
    }

    public ProfileResponseDto toDto (Profile profile){
        return new ProfileResponseDto(
                profile.id(),
                profile.userName(),
                profile.biography()
        );
    }
}
