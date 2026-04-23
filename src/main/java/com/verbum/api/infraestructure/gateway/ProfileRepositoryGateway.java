package com.verbum.api.infraestructure.gateway;

import com.verbum.api.core.domain.Profile;
import com.verbum.api.core.gateway.ProfileGateway;
import com.verbum.api.infraestructure.mapper.profile.ProfileEntityMapper;
import com.verbum.api.infraestructure.persistence.repositories.ProfileRepository;

import java.util.Optional;
import java.util.UUID;

public class ProfileRepositoryGateway implements ProfileGateway {

    private final ProfileRepository profileRepository;
    private final ProfileEntityMapper mapper;

    public ProfileRepositoryGateway(ProfileRepository profileRepository,
                                    ProfileEntityMapper mapper
                                    ) {
        this.profileRepository = profileRepository;
        this.mapper = mapper;
    }
    @Override
    public Optional<Profile> getProfile(UUID id) {
        return profileRepository.findById(id)
                .map(mapper::toDomain);
    }
}
