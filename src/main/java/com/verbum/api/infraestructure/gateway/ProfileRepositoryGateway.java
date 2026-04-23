package com.verbum.api.infraestructure.gateway;

import com.verbum.api.core.domain.Profile;
import com.verbum.api.core.gateway.ProfileGateway;
import com.verbum.api.infraestructure.mapper.profile.ProfileEntityMapper;
import com.verbum.api.infraestructure.persistence.repositories.ProfileRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;
@Component
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

    @Override
    public Profile createProfile(Profile profile) {
        return this.mapper.toDomain(profileRepository.save(mapper.toEntity(profile)));
    }

    @Override
    public boolean checkUserName(String username){
        return profileRepository.existsByUsername(username);
    }
}
