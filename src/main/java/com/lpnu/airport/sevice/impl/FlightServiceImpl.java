package com.lpnu.airport.sevice.impl;

import com.lpnu.airport.entity.Flight;
import com.lpnu.airport.entity.Plane;
import com.lpnu.airport.entity.Ticket;
import com.lpnu.airport.repository.FlightRepository;
import com.lpnu.airport.repository.TicketRepository;
import com.lpnu.airport.sevice.FlightService;
import com.lpnu.airport.sevice.PlaneService;
import com.lpnu.airport.sevice.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final TicketService ticketService;
    private final TicketRepository ticketRepository;
    private final PlaneService planeService;
    private final FlightRepository flightRepository;

    private final static String CHARS = "ABCDEF";

    @Override
    public void createFlight(Long planeId, LocalDateTime date) {
        Plane plane = planeService.findEntityById(planeId);

        List<Ticket> ticketList = new ArrayList<>();

        final Flight flight = new Flight();

        flight.setDateTime(date);
        flight.setPlane(plane);

        flightRepository.save(flight);


        for(int i = 1; i < plane.getNumberOfSeats()/plane.getRowSeats(); i++){
            for(int j = 1 ; j <= plane.getRowSeats(); j++){
                Ticket ticket = new Ticket();

                ticket.setFlight(flight);
                ticket.setPrice(BigDecimal.valueOf(1000));
                ticket.setPlace("" + i + CHARS.charAt(j - 1));

                ticketList.add(ticket);
            }
        }

        ticketRepository.saveAll(ticketList);

    }
}
