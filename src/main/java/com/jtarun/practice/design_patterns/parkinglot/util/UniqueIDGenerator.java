package com.jtarun.practice.design_patterns.parkinglot.util;

public class UniqueIDGenerator {
    private int val;

    public UniqueIDGenerator() {
        this.val = 0;
    }

    public UniqueIDGenerator(int val) {
        this.val = val;
    }

    public int get() {
        this.val++;
        return val;
    }
}
