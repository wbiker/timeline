package com.bastelbude.timeline.controller;

import com.bastelbude.timeline.model.StoryModel;
import com.bastelbude.timeline.services.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoryController {

  @Autowired
  private StoryService storyService;

  @GetMapping("/stories")
  public List<StoryModel> getStories() {
    return storyService.findAll();
  }

  @PostMapping("/stories")
  public StoryModel storeStory(@RequestBody StoryModel storyModel) {
    return storyService.save(storyModel);
  }
}
