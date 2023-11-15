package com.lpnu.airport.repository.stream;

import com.lpnu.airport.entity.Ticket;
import com.lpnu.airport.exceptions.BadRequestException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TicketStreamRepository {
    private List<Ticket> ticketList = new ArrayList<>();

    private Long lastUsedId = 0L;

    private Long generateId(){
        ++lastUsedId;
        return lastUsedId;
    }

    public Ticket save(final Ticket ticket){
        ticket.setId(generateId());
        ticketList.add(ticket);
        return ticket;
    }

    public Ticket update(final Ticket ticket){
        Ticket savedTicket = findById(ticket.getId())
                .orElseThrow(() -> new BadRequestException(String.format("Ticket with id {%s} not found", ticket.getId())));

        return savedTicket;
    }

    public List<Ticket> findAll(){
        return ticketList;
    }

    public Optional<Ticket> findById(final Long id){
        return ticketList.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    public void deleteById(final Long id){
        ticketList = ticketList.stream()
                .filter(e -> e.getId().equals(id))
                .collect(Collectors.toList());
    }
}
