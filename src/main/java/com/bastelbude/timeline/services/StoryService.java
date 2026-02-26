package com.bastelbude.timeline.services;

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
}
