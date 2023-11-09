package com.lpnu.airport.resource;

import com.lpnu.airport.sevice.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/flight")
@RequiredArgsConstructor
public class TicketResource {
    private final TicketService ticketService;

    @PostMapping("/{userId}/{ticketId}")
    public void buyTicket(@PathVariable Long userId, @PathVariable Long ticketId){
        ticketService.buyTicket(ticketId, userId);
    }
}
