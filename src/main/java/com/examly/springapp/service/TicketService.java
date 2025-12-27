package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Ticket;
import com.examly.springapp.repository.TicketRepo;

@Service
public class TicketService {
    @Autowired
    private TicketRepo ticketRepo;
    public void createTickets(Ticket ticket){
        ticketRepo.save(ticket);
    }
}
