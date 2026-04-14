package com.bastelbude.timeline.entities;

import com.bastelbude.timeline.model.Weekdays;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Story {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long identifier;

  @Column
  Long storyId;

  @Column
  String title;

  @Column
  Boolean isPermanent;

  @Column
  Weekdays weekdays = Weekdays.All;

  @Column
  int offsetInWeeks;

  @Column
  LocalDate timestampForOffset;

  @OneToMany(mappedBy = "story", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<StoryOccurrence> occurrences = new ArrayList<>();

  public void addOccurrence(StoryOccurrence occurrence) {
    occurrences.add(occurrence);
    occurrence.setStory(this);
  }

  public void removeOccurrence(StoryOccurrence occurrence) {
    occurrences.remove(occurrence);
    occurrence.setStory(null);
  }
}
