package com.lpnu.airport.sevice.impl;

import com.lpnu.airport.entity.Flight;
import com.lpnu.airport.entity.Ticket;
import com.lpnu.airport.entity.User;
import com.lpnu.airport.exceptions.BadRequestException;
import com.lpnu.airport.repository.TicketRepository;
import com.lpnu.airport.repository.UserRepository;
import com.lpnu.airport.sevice.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    @Override
    public void buyTicket(Long ticketId, Long userId) {
        //todo: make code better and safe
        User user = userRepository.findById(userId).get();

        Ticket ticket = findById(ticketId);
        user.setMoney(user.getMoney().subtract(ticket.getPrice()));
        userRepository.update(user);

        ticket.setUser(user);
        ticketRepository.update(ticket);
    }

    @Override
    public void releaseTicket(final Long ticketId) {
        final Ticket ticket = findById(ticketId);

        final User user = ticket.getUser();

        user.setMoney(user.getMoney().add(ticket.getPrice()));
        userRepository.update(user);

        ticketRepository.deleteById(ticket.getId());
    }

    @Override
    public void generateTicketsForFlight(Flight flight) {
        for(int i = 0; i < flight.getNumberOfPlaces(); i++){
            final Ticket ticket = new Ticket();

            ticket.setFlight(flight);

            //TODO: remove magic number. Should depends on plane model
            ticket.setPlace(placeNameGenerator(i, 3));
            ticket.setPrice(BigDecimal.valueOf(100));

            ticketRepository.save(ticket);
        }
    }

    private Ticket findById(final Long ticketId){
        return ticketRepository.findById(ticketId)
                .orElseThrow(() -> new BadRequestException(String.format("Ticket with id {%s} not found", ticketId)));
    }

    private String placeNameGenerator(int currentPlace, int placesInRow){
        int rowNumber = currentPlace % placesInRow;

        return "" + rowNumber + "A";
    }
}
