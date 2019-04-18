package com.jtarun.practice.design_patterns.parkinglot.cache;

import com.jtarun.practice.design_patterns.parkinglot.model.Car;
import com.jtarun.practice.design_patterns.parkinglot.model.Slot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ParkingCache implements IParkingCache {
    private Map<Slot, Car> slotToCarCache = new HashMap<>();

    // For queries
    private Map<String, Set<String>> colorToRegistrationCache = new HashMap<>();
    private Map<String, Integer> registrationToSlotCache = new HashMap<>();
    private Map<String, Set<Integer>> colorToSlots = new HashMap<>();

    public void put(Car car, Slot slot) {
        slotToCarCache.put(slot, car);

        colorToRegistrationCache.computeIfAbsent(car.getColor(), k -> new HashSet<>())
                .add(car.getRegistrationNumber());

        colorToSlots.computeIfAbsent(car.getColor(), k -> new HashSet<>())
                .add(slot.getId());

        registrationToSlotCache.put(car.getRegistrationNumber(), slot.getId());
    }

    public void remove(Slot slot) {
        if (!slotToCarCache.containsKey(slot)) {
            return;
        }

        Car car = slotToCarCache.get(slot);

        Set<String> carsList = colorToRegistrationCache.get(car.getColor());
        if (carsList != null) {
            carsList.remove(car.getRegistrationNumber());
        }


        Set<Integer> slots = colorToSlots.get(car.getColor());
        if (slots != null) {
            slots.remove(slot.getId());
        }
    }

    public Set<String> getRegistrationsWithColor(String color) {
        return colorToRegistrationCache.getOrDefault(color, new HashSet<>());
    }

    public Integer getSlot(String registration) {
        return registrationToSlotCache.get(registration);
    }

    public Set<Integer> getSlotsWithColor(String color) {
        return colorToSlots.getOrDefault(color, new HashSet<>());
    }

}