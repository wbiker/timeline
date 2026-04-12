package com.bastelbude.timeline.model;

public record StoryModel(Long identifier,
                         Long storyId,
                         String title,
                         Boolean isPermanent,
                         Weekdays weekday,
                         int offsetInDays,
                         String timestampForOffset) {
}
