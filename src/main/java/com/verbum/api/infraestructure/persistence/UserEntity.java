package com.verbum.api.infraestructure.persistence;

import com.verbum.api.core.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String email;
    private String password;
    @Column(name = "isactive")
    private Boolean isActive;
    @Enumerated(EnumType.STRING)
    private Role role;

}
