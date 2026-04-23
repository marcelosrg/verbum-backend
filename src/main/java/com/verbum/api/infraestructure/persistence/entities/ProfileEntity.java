package com.verbum.api.infraestructure.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="profiles")
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;

    private String userName;

    private String biography;

    @Column(nullable = true)
    private String imageUrl;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "userId", unique = true, nullable = false)
    private UserEntity userEntity;
}
