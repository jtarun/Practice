package com.jtarun.practice.design_patterns.parkinglot.model;

public class Slot {
    private final int id;
    private boolean available;

    public Slot(int id) {
        this.id = id;
        available = true;
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

