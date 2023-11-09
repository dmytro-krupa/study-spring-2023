package com.lpnu.airport.resource;

import com.lpnu.airport.sevice.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/flight")
@RequiredArgsConstructor
public class FlightResource {
    private final FlightService flightService;

    @GetMapping
    public void generator(){
        flightService.generateTestFlight();
    }
}
