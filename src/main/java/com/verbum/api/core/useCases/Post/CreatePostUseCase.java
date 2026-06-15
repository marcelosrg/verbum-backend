package com.verbum.api.core.useCases.Post;

import com.verbum.api.core.domain.Post;

public interface CreatePostUseCase {
    Post execute(Post post);
}
