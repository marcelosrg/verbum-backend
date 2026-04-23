package com.verbum.api.infraestructure.persistence.repositories;

import com.verbum.api.infraestructure.persistence.entities.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfileRepository extends JpaRepository<ProfileEntity, UUID> {
}
