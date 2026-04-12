package com.bastelbude.timeline.model;

public record StoryOccurrenceModel(
    Long identifier,
    Long storyIdentifier,
    Long monday,
    Long tuesday,
    Long wednesday,
    Long thursday,
    Long friday,
    Long total
) {}
