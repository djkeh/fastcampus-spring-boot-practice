package com.fastcampus.springbootpractice.domain;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor(staticName = "of")
@ToString
public class Seat {
    private final Car car;
}
