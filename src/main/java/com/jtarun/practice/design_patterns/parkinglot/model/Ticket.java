package com.jtarun.practice.design_patterns.parkinglot.model;

public class Ticket {
    private final int id;
    private final Slot slot;
    private final Car car;

    public Ticket(int id, Slot slot, Car car) {
        this.id = id;
        this.slot = slot;
        this.car = car;
    }

    public Slot getSlot() {
        return slot;
    }

    public Car getCar() {
        return car;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + this.id +
                ", slot=" + slot.getId() +
                ", registrationNumber=" + car.getRegistrationNumber() +
                ", color=" + car.getColor() +
                '}';
    }
}
