package com.bastelbude.timeline.model;

import lombok.Builder;

@Builder
public record StoryModel(Long id, Long storyId, String title) {
}
