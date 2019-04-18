package com.jtarun.practice.design_patterns.parkinglot;

import com.jtarun.practice.design_patterns.parkinglot.model.Ticket;
import com.jtarun.practice.design_patterns.parkinglot.util.ParkingLotUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotApp {

    public static void main(String[] args) throws Exception {

        Map<Integer, List<Integer>> entryPointsConfig = new HashMap<>();
        entryPointsConfig.put(1, Arrays.asList(1, 2, 3));
        entryPointsConfig.put(2, Arrays.asList(2, 5, 6));
        entryPointsConfig.put(3, Arrays.asList(7, 8, 2, 5, 6));

        ParkingLotUtil parkingLotUtil = new ParkingLotUtil(entryPointsConfig);
        Ticket ticket1 = parkingLotUtil.park("ABC", "WHITE", 1);

        Ticket ticket2 = parkingLotUtil.park("DEF", "BLUE", 2);
        Ticket ticket3 = parkingLotUtil.park("GHI", "BLUE", 2);

        parkingLotUtil.getSlotsWithColor("BLUE").forEach(System.out::println);

        parkingLotUtil.getRegistrationsWithColor("BLUE").forEach(System.out::println);

        System.out.println(parkingLotUtil.getSlot("DEF"));

        parkingLotUtil.printTickets();

        parkingLotUtil.unpark(ticket2.getSlot().getId());
        parkingLotUtil.printTickets();

        parkingLotUtil.park("LMN", "BLUE", 2);
        parkingLotUtil.printTickets();
    }
}
