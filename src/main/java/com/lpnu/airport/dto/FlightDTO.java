package com.lpnu.airport.dto;

import com.lpnu.airport.entity.Plane;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightDTO {
    private LocalDateTime dateTime;
    private Long planeId;
}
