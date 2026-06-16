package com.verbum.api.core.useCases.Post;

import com.verbum.api.core.domain.Posts;

public interface CreatePostUseCase {
    Posts execute(Posts post);
}
