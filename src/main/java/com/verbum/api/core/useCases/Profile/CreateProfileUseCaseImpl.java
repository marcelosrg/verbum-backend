package com.verbum.api.core.useCases.Profile;

import com.verbum.api.core.domain.Profile;
import com.verbum.api.core.exceptions.DuplicateException;
import com.verbum.api.core.gateway.ProfileGateway;

public class CreateProfileUseCaseImpl implements CreateProfileUseCase {

    private final ProfileGateway profileGateway;

    public CreateProfileUseCaseImpl(ProfileGateway profileGateway) {
        this.profileGateway = profileGateway;
    }
    @Override
    public Profile execute(Profile profile) {
        if(profileGateway.checkUserName(profile.username())){
            throw new DuplicateException("O usuario não está disponivel!");
        }
        return profileGateway.createProfile(profile);
    }
}
