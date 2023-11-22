package com.lpnu.airport.sevice;

import java.time.LocalDateTime;

public interface FlightService {
    void createFlight(Long planeId, LocalDateTime date);
}
