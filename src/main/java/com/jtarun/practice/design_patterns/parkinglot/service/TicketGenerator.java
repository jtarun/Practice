package com.jtarun.practice.design_patterns.parkinglot.service;

import com.jtarun.practice.design_patterns.parkinglot.model.Car;
import com.jtarun.practice.design_patterns.parkinglot.model.Slot;
import com.jtarun.practice.design_patterns.parkinglot.model.Ticket;
import com.jtarun.practice.design_patterns.parkinglot.util.UniqueIDGenerator;

class TicketGenerator{
    private UniqueIDGenerator idGenerator = new UniqueIDGenerator();

    public Ticket generateTicket(Car car, Slot slot) {
        return new Ticket(idGenerator.get(), slot, car);
    }
}

