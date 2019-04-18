package com.jtarun.practice.design_patterns.parkinglot.repo;

import com.jtarun.practice.design_patterns.parkinglot.model.Ticket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketRepo {

    Map<Integer, Ticket> ticketsCache = new HashMap<>();

    public void save(Ticket ticket) {
        ticketsCache.put(ticket.getId(), ticket);
    }

    public void remove(Ticket ticket) {
        ticketsCache.remove(ticket.getId());
    }

    public List<Ticket> getAllTickets() {
        return new ArrayList<>(ticketsCache.values());
    }
}
