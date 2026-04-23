package com.verbum.api.core.gateway;

import com.verbum.api.core.domain.Profile;

import java.util.Optional;
import java.util.UUID;

public interface ProfileGateway {

    Optional<Profile> getProfile(UUID id);
    Profile createProfile(Profile profile);
    boolean checkUserName(String username);

}
