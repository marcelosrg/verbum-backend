package com.verbum.api.core.useCases.Profile;

import com.verbum.api.core.domain.Profile;
import com.verbum.api.core.exceptions.NotFoundException;
import com.verbum.api.core.gateway.ProfileGateway;

import java.util.Optional;
import java.util.UUID;

public class GetProfileUseCaseImpl implements GetProfileUseCase {

    private final ProfileGateway profileGateway;

    public GetProfileUseCaseImpl(ProfileGateway profileGateway) {
        this.profileGateway = profileGateway;
    }

    @Override
    public Profile execute(UUID id) {
        return profileGateway.getProfile(id)
                .orElseThrow(() ->
                        new NotFoundException("Perfil não encontrado!")
                );
    }
}
