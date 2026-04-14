package com.bastelbude.timeline.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StoryOccurrence {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long identifier;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "story", nullable = false)
  Story story;

  @Column
  Integer weeknumber;

  @Column
  Long monday;

  @Column
  Long tuesday;

  @Column
  Long wednesday;

  @Column
  Long thursday;

  @Column
  Long friday;

  @Column
  Long total;
}
