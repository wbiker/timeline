package com.bastelbude.timeline.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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
  Date date;

    @Column
  int offsetInDays;
}
