package com.bastelbude.timeline.repositories;

import com.bastelbude.timeline.entities.StoryOccurrence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoryOccurrenceRepository extends JpaRepository<StoryOccurrence, Long> {
  List<StoryOccurrence> findByWeeknumber(int weeknumber);
}
