package com.lpnu.airport.resource;

import com.lpnu.airport.dto.CreateFlightDTO;
import com.lpnu.airport.sevice.FlightService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/flight")
@RequiredArgsConstructor
public class FlightResource {
    private final FlightService flightService;

    @PostMapping
    public void createFlight(final @RequestBody @Valid CreateFlightDTO createFlightDTO){
        createFlightDTO.validate();
        flightService.createFlight(createFlightDTO.getPlaneId(), createFlightDTO.getDateTime());
    }
}
