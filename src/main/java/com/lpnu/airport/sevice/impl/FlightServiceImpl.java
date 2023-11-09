package com.lpnu.airport.sevice.impl;

import com.lpnu.airport.entity.Flight;
import com.lpnu.airport.sevice.FlightService;
import com.lpnu.airport.sevice.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final TicketService ticketService;
    @Override
    public void generateTestFlight() {

        final Flight flight = new Flight();
        flight.setDateTime(LocalDateTime.now());
//        flight.setNumberOfPlaces(6);
        ticketService.generateTicketsForFlight(flight);
    }
}
