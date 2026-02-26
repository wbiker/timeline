package com.bastelbude.timeline.repositories;

import com.bastelbude.timeline.entities.Story;
import org.springframework.data.jpa.repository.JpaRepository;import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {
}
