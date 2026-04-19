package com.bastelbude.timeline.model;

public record StoryOccurrenceModel(
    Long identifier,
    String title,
    int weeknumber,
    Long monday,
    Long tuesday,
    Long wednesday,
    Long thursday,
    Long friday,
    Long total
) {}
