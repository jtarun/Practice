package com.jtarun.practice.design_patterns.parkinglot.service;

import com.jtarun.practice.design_patterns.parkinglot.repo.TicketRepo;
import com.jtarun.practice.design_patterns.parkinglot.cache.IParkingCache;
import com.jtarun.practice.design_patterns.parkinglot.model.Car;
import com.jtarun.practice.design_patterns.parkinglot.model.EntryPoint;
import com.jtarun.practice.design_patterns.parkinglot.model.Slot;
import com.jtarun.practice.design_patterns.parkinglot.model.Ticket;

import java.util.*;

public class ParkingLot {

    private final Map<Integer, Slot> slotIdToSlots;
    private final TicketGenerator ticketGenerator;
    private final IParkingCache parkingCache;
    private final TicketRepo ticketRepo;

    private final Map<Integer, Ticket> slotToTicketCache;

    public ParkingLot(Map<Integer, Slot> slotIdToSlots, IParkingCache parkingCache, TicketRepo ticketRepo) {
        this.slotIdToSlots = slotIdToSlots;
        this.ticketGenerator = new TicketGenerator();
        this.parkingCache = parkingCache;
        this.ticketRepo = ticketRepo;
        this.slotToTicketCache = new HashMap<>();
    }

    public Ticket park(Car car, EntryPoint entryPoint) throws Exception {
        List<Slot> slots = entryPoint.getSlots();

        for (Slot slot : slots) {
            if (slot.isAvailable()) {
                parkingCache.put(car, slot);

                Ticket ticket = ticketGenerator.generateTicket(car,slot);
                ticketRepo.save(ticket);
                slotToTicketCache.put(slot.getId(), ticket);

                slot.setAvailable(false);
                return ticket;
            }
        }

        throw new Exception("No free slots found!!!");
    }

    public void unpark(int slotId) {
        Slot slot = slotIdToSlots.get(slotId);

        if (slot != null) {
            slot.setAvailable(true);

            parkingCache.remove(slot);

            ticketRepo.remove(slotToTicketCache.get(slotId));
            slotToTicketCache.remove(slotId);
        }
    }

}
