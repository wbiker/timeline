package com.bastelbude.timeline.controller;

import com.bastelbude.timeline.mapper.StoryMapper;
import com.bastelbude.timeline.mapper.StoryOccurrenceMapper;
import com.bastelbude.timeline.model.StoryOccurrenceModel;
import com.bastelbude.timeline.services.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoryOccurrenceController {

  @Autowired
  private StoryService storyService;

  private final StoryMapper storyMapper = StoryMapper.INSTANCE;
  private final StoryOccurrenceMapper storyOccurrenceMapper = StoryOccurrenceMapper.INSTANCE;

  @GetMapping("/storyoccurrence/{weeknumber}")
  public List<StoryOccurrenceModel> getStoryOccurrence(@PathVariable int weeknumber) {
    return storyService.findAllForWeeknumber(weeknumber)
                       .stream()
                       .map(storyOccurrenceMapper::toModel)
                       .toList();
  }

  @PostMapping(value="/storyoccurrence", consumes="application/json", produces="application/json")
  @ResponseBody
  public StoryOccurrenceModel storeStory(@RequestBody StoryOccurrenceModel storyOccurrenceModel) {
   return storyOccurrenceMapper.toModel(storyService.save(storyOccurrenceModel));
  }
}
