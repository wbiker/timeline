package com.bastelbude.timeline.mapper;

import com.bastelbude.timeline.entities.Story;
import com.bastelbude.timeline.model.StoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StoryMapper {
  StoryMapper INSTANCE = Mappers.getMapper(StoryMapper.class);

  StoryModel toModel(Story story);

  Story toEntity(StoryModel storyModel);
}
