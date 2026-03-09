package com.bastelbude.timeline.services;

import com.bastelbude.timeline.entities.Story;
import com.bastelbude.timeline.mapper.StoryMapper;
import com.bastelbude.timeline.model.StoryModel;
import com.bastelbude.timeline.repositories.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryService {

  @Autowired
  private StoryRepository repository;

  private final StoryMapper storyMapper = StoryMapper.INSTANCE;

  public List<Story> findAll() {
    return repository.findAll();
  }

  public Story save(StoryModel storyModel) {
    Story entity = storyMapper.toEntity(storyModel);
    return repository.save(entity);
  }
}
