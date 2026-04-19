package com.bastelbude.timeline.mapper;

import com.bastelbude.timeline.entities.StoryOccurrence;
import com.bastelbude.timeline.model.StoryOccurrenceModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StoryOccurrenceMapper {
  StoryOccurrenceMapper INSTANCE = Mappers.getMapper(StoryOccurrenceMapper.class);

  StoryOccurrenceModel toModel(StoryOccurrence storyOccurrence);

  StoryOccurrence toEntity(StoryOccurrenceModel storyOccurrenceModel);
}
