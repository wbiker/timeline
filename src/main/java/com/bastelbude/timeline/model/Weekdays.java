package com.bastelbude.timeline.model;

import lombok.Getter;

@Getter
public enum Weekdays {
  Monday("Monday"),
  Tuesday("Tuesday"),
  Wednesday("Wednesday"),
  Thursday("Thursday"),
  Friday("Friday"),
  All("All");

  final private String value;

  Weekdays(String value) {
    this.value = value;
  }
}
