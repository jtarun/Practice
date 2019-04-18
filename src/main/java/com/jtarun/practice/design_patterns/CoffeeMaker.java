package com.jtarun.practice.design_patterns;

interface Coffee {
    int getCost();
    String getDesc();
}

class BasicCoffee implements Coffee {
    public int getCost() {
        return 5;
    }

    public String getDesc() {
        return "Basic";
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}

class Milk extends CoffeeDecorator {

    public Milk(Coffee coffee) {
        super(coffee);
    }

    public int getCost() {
        return 2 + coffee.getCost();
    }

    public String getDesc() {
        return "milk, " + coffee.getDesc();
    }
}


class Sugar extends CoffeeDecorator {

    public Sugar(Coffee coffee) {
        super(coffee);
    }

    public int getCost() {
        return 1 + coffee.getCost();
    }

    public String getDesc() {
        return "sugar, " + coffee.getDesc();
    }
}

public class CoffeeMaker {

    public static void main(String[] args) {
        Coffee coffee = new Milk(new Sugar(new BasicCoffee()));
        System.out.println(coffee.getCost());
        System.out.println(coffee.getDesc());
    }
}
