package com.bastelbude.timeline.services;

import com.bastelbude.timeline.entities.Story;
import com.bastelbude.timeline.repositories.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryService {

  @Autowired
  private StoryRepository repository;

  public List<Story> findAll() {
    return repository.findAll();
  }
}
