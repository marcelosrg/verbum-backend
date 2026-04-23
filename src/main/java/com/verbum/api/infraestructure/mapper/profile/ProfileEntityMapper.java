package com.verbum.api.infraestructure.mapper.profile;

import com.verbum.api.core.domain.Profile;
import com.verbum.api.core.domain.User;
import com.verbum.api.infraestructure.mapper.user.UserEntityMapper;
import com.verbum.api.infraestructure.persistence.entities.ProfileEntity;

public class ProfileEntityMapper {

    private final UserEntityMapper userEntityMapper;

    public ProfileEntityMapper(UserEntityMapper userEntityMapper) {
        this.userEntityMapper = userEntityMapper;
    }

    public Profile toDomain(ProfileEntity entity) {

       return new Profile(
               entity.getId(),
               entity.getUserName(),
               entity.getBiography(),
               userEntityMapper.toDomain(entity.getUserEntity())
       );
    }


    public ProfileEntity toEntity(Profile profile) {

        return new ProfileEntity(
            profile.id(),
                profile.userName(),
                profile.biography(),
                userEntityMapper.toEntity(profile.user())
        );

    }
}
