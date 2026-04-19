package com.bastelbude.timeline.services;

import com.bastelbude.timeline.entities.Story;
import com.bastelbude.timeline.entities.StoryOccurrence;
import com.bastelbude.timeline.mapper.StoryMapper;
import com.bastelbude.timeline.mapper.StoryOccurrenceMapper;
import com.bastelbude.timeline.model.StoryModel;
import com.bastelbude.timeline.model.StoryOccurrenceModel;
import com.bastelbude.timeline.repositories.StoryOccurrenceRepository;
import com.bastelbude.timeline.repositories.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryService {

  @Autowired
  private StoryRepository repository;
  @Autowired
  private StoryOccurrenceRepository occurrenceRepository;

  private final StoryMapper storyMapper = StoryMapper.INSTANCE;
  private final StoryOccurrenceMapper storyOccurrenceMapper = StoryOccurrenceMapper.INSTANCE;

  public List<Story> findAll() {
    return repository.findAll();
  }

  public List<StoryOccurrence> findAllForWeeknumber(int weeknumber) {
    return occurrenceRepository.findByWeeknumber(weeknumber);
  }

  public Story save(StoryModel storyModel) {
    Story entity = storyMapper.toEntity(storyModel);
    return repository.save(entity);
  }

  public StoryOccurrence save(StoryOccurrenceModel storyOccurrenceModel) {
    StoryOccurrence entity = storyOccurrenceMapper.toEntity(storyOccurrenceModel);
    return occurrenceRepository.save(entity);
  }
}
