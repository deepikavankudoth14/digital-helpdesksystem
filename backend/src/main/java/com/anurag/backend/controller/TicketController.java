package com.anurag.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.backend.entity.Ticket;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "*")
public class TicketController {

    private final List<Ticket> tickets = new ArrayList<>();
    private long nextId = 1;

    @GetMapping
    public List<Ticket> getTickets() {
        return tickets;
    }

    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        ticket.setId(nextId++);
        ticket.setStatus("OPEN");
        tickets.add(ticket);
        return ticket;
    }
}