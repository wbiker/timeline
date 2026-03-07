package com.bastelbude.timeline.controller;

import com.bastelbude.timeline.mapper.StoryMapper;
import com.bastelbude.timeline.model.StoryModel;
import com.bastelbude.timeline.services.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@RestController
public class StoryController {

  @Autowired
  private StoryService storyService;

  private final StoryMapper storyMapper = StoryMapper.INSTANCE;

  @GetMapping("/stories")
  public List<StoryModel> getStories() {
    return storyService.findAll()
                       .stream()
                       .map(storyMapper::toModel)
                       .toList();
  }

  @PostMapping(value="/stories", consumes="application/json", produces="application/json")
  @ResponseBody
  public StoryModel storeStory(@RequestBody StoryModel storyModel) {
    return storyMapper.toModel(storyService.save(storyModel));
  }

  @Bean
  UrlBasedCorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList("https://example.com"));
    configuration.setAllowedMethods(Arrays.asList("GET","POST"));
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }
}
