package com.bastelbude.timeline.services;

import com.bastelbude.timeline.entities.Story;
import com.bastelbude.timeline.model.StoryModel;
import com.bastelbude.timeline.repositories.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryService {

  @Autowired
  private StoryRepository repository;

  public List<StoryModel> findAll() {
    return repository.findAll().stream()
      .map(storyEntity -> new StoryModel(storyEntity.getIdentifier(), storyEntity.getStoryId(), storyEntity.getTitle()))
      .toList();
  }

  public StoryModel save(StoryModel storyModel) {
    Story storyEntity = new Story(storyModel.id(), storyModel.storyId(), storyModel.title());
    var entitySaved = repository.save(storyEntity);
    return StoryModel.builder()
            .id(entitySaved.getIdentifier())
            .storyId(entitySaved.getStoryId())
            .title(entitySaved.getTitle())
            .build();
  }
}
