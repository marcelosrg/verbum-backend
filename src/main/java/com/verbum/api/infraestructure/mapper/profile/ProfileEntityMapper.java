package com.verbum.api.infraestructure.mapper.profile;

import com.verbum.api.core.domain.Profile;
import com.verbum.api.infraestructure.persistence.entities.ProfileEntity;
import com.verbum.api.infraestructure.persistence.entities.UserEntity;

public class ProfileEntityMapper {

    public Profile toDomain(ProfileEntity entity) {

        return new Profile(
                entity.getId(),
                entity.getUserName(),
                entity.getImageUrl(),
                entity.getBiography(),
                entity.getUserEntity().getId()
        );
    }

    public ProfileEntity toEntity(Profile profile) {

        UserEntity user = new UserEntity();
        user.setId(profile.userId());

        return new ProfileEntity(
                profile.id(),
                profile.userName(),
                profile.imageUrl(),
                profile.biography(),
                user
        );
    }
}