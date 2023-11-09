package com.lpnu.airport.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    private Long id;
    private LocalDateTime dateTime;

    private int numberOfPlaces;
}
