package com.lpnu.airport.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plane {
    private Long id;
    private String model;
    private int numberOfSeats;
}
