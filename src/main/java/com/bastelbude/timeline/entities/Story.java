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
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long identifier;

    @Column(name = "storyid")
    Long storyId;

    @Column
    String title;
}
