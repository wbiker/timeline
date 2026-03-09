package com.bastelbude.timeline.model;

import lombok.Builder;

import java.util.Date;

@Builder
public record StoryModel(Long id, Long storyId, String title, boolean isPermanent, Date date, int offsetInDays) {
}
