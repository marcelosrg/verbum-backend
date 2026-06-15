package com.verbum.api.infraestructure.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostEntity {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;

    private String title;
    private String content;
    private String slug;
    private String coverImageUrl;
    private boolean published;
    private LocalDateTime publishedAt;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserEntity author;
}
