package com.fastcampus.springbootpractice.domain;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data(staticConstructor = "of")
@ToString
public class Car {
    private final String name;
    private List<Seat>  seats;
}
