package com.verbum.api.core.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public record Posts(UUID id,
                   User user,
                   String title,
                   String slug,
                   String content,
                   String coverImageUrl,
                   boolean published,
                   LocalDateTime publishedAt) { }
