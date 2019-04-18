package com.jtarun.practice.design_patterns.parkinglot.cache;

import com.jtarun.practice.design_patterns.parkinglot.model.Car;
import com.jtarun.practice.design_patterns.parkinglot.model.Slot;

import java.util.Set;

public interface IParkingCache {

    void put(Car car, Slot slot);
    void remove(Slot slot);
    Set<String> getRegistrationsWithColor(String color);
    Integer getSlot(String registration);
    Set<Integer> getSlotsWithColor(String color);
}
