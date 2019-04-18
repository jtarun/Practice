package com.jtarun.practice.design_patterns.parkinglot.model;

import java.util.List;

public class EntryPoint {
    private final int id;
    private final List<Slot> slots; // slots accessible from this entryPoint in increasing distance order.

    public EntryPoint(int id, List<Slot> slots) {
        this.id = id;
        this.slots = slots;
    }

    public int getId() {
        return id;
    }

    public List<Slot> getSlots() {
        return slots;
    }
}
