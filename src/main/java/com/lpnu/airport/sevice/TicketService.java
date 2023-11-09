package com.lpnu.airport.sevice;

import com.lpnu.airport.entity.Flight;
import com.lpnu.airport.entity.Ticket;
import com.lpnu.airport.entity.User;

public interface TicketService {

    void generateTicketsForFlight(Flight flight);
    void buyTicket(Long ticketId, Long userId);

    void releaseTicket(Long ticketId);
}
