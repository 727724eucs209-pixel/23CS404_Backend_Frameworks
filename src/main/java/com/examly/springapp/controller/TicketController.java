package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Ticket;
import com.examly.springapp.service.TicketService;

@RestController
@RequestMapping("/api")
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @PostMapping("/tickets/{ticketId}")
    public void createTickets(@PathVariable long ticketId, @RequestBody Ticket ticket){
        ticket.setTicketId(ticketId);
        ticketService.createTickets(ticket);
    }
}
