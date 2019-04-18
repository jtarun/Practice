package com.jtarun.practice.design_patterns.parkinglot.util;

import com.jtarun.practice.design_patterns.parkinglot.service.ParkingLot;
import com.jtarun.practice.design_patterns.parkinglot.repo.TicketRepo;
import com.jtarun.practice.design_patterns.parkinglot.cache.IParkingCache;
import com.jtarun.practice.design_patterns.parkinglot.cache.ParkingCache;
import com.jtarun.practice.design_patterns.parkinglot.model.Car;
import com.jtarun.practice.design_patterns.parkinglot.model.EntryPoint;
import com.jtarun.practice.design_patterns.parkinglot.model.Slot;
import com.jtarun.practice.design_patterns.parkinglot.model.Ticket;

import java.util.*;

public class ParkingLotUtil {

    private final ParkingLot parkingLot;
    private final IParkingCache parkingCache;
    private final TicketRepo ticketRepo;

    private final Map<Integer, EntryPoint> entryPointMap;

    // Input is entryPoint to list of slots accessible from here in sorted order.
    public ParkingLotUtil(Map<Integer, List<Integer>> entryPointsConfig) {

        this.parkingCache = new ParkingCache();

        // create slots;
        Map<Integer, Slot> slotIdToSlots = new HashMap<>();
        this.entryPointMap = new HashMap<>();

        for (Integer entryPointId : entryPointsConfig.keySet()) {
            List<Integer> slotIds = entryPointsConfig.get(entryPointId);

            List<Slot> slots = new ArrayList<>();
            for (int slotId : slotIds) {
                if (!slotIdToSlots.containsKey(slotId)) {
                    Slot slot = new Slot(slotId);
                    slotIdToSlots.put(slotId, slot);
                }
                slots.add(slotIdToSlots.get(slotId));
            }
            EntryPoint entryPoint = new EntryPoint(entryPointId, slots);
            entryPointMap.put(entryPointId, entryPoint);
        }

        this.ticketRepo = new TicketRepo();
        this.parkingLot = new ParkingLot(slotIdToSlots, parkingCache, ticketRepo);
    }

    public Ticket park(String registrationNumber, String carColor, int entryPointId) throws Exception {
        EntryPoint entryPoint =  entryPointMap.get(entryPointId);
        if (entryPoint == null) {
            throw new Exception("No such entry point!!!");
        }

        Car car = new Car(registrationNumber, carColor);
        Ticket ticket;
        try {
            ticket = parkingLot.park(car, entryPoint);

            System.out.println("Generated ticket : " + ticket.toString());

        } catch (Exception e) {
            System.out.println("Parking lot is full");
            throw e;
        }

        return ticket;
    }

    public void unpark(int slotId) {
        parkingLot.unpark(slotId);
    }

    public Set<String> getRegistrationsWithColor(String color) {
        return parkingCache.getRegistrationsWithColor(color);
    }

    public Integer getSlot(String registration) {
        return parkingCache.getSlot(registration);
    }

    public Set<Integer> getSlotsWithColor(String color) {
        return parkingCache.getSlotsWithColor(color);
    }

    public void printTickets() {
        ticketRepo.getAllTickets().forEach(System.out::println);
        System.out.println();
    }

}
