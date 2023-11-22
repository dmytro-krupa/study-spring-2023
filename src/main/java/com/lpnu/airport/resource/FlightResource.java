package com.lpnu.airport.resource;

import com.lpnu.airport.sevice.FlightService;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/flight")
@RequiredArgsConstructor
public class FlightResource {
    private final FlightService flightService;

    @PostMapping("/{planeId}")
    public void createFlight(final @PathVariable @Positive Long planeId,
                             final @RequestParam @FutureOrPresent @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)  LocalDateTime date){
        flightService.createFlight(planeId, date);
    }
}
