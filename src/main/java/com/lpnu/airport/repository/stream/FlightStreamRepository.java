package com.lpnu.airport.repository.stream;

import com.lpnu.airport.entity.Flight;
import com.lpnu.airport.exceptions.BadRequestException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class FlightStreamRepository {
    private List<Flight> flightList = new ArrayList<>();

    private Long lastFlightId = 0L;

    private Long generateId(){
        ++lastFlightId;
        return lastFlightId;
    }

    public Flight save(final Flight flight){
        flight.setId(generateId());
        flightList.add(flight);
        return flight;
    }

    public Flight update(final Flight flight){
        Flight savedFlight = findById(flight.getId())
                .orElseThrow(() -> new BadRequestException(String.format("Flight with id {%s} not found", flight.getId())));

        return savedFlight;
    }

    public List<Flight> findAll(){
        return flightList;
    }

    public Optional<Flight> findById(final Long id){
        return flightList.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    public void deleteById(final Long id){
        flightList = flightList.stream()
                .filter(e -> e.getId().equals(id))
                .collect(Collectors.toList());
    }
}
