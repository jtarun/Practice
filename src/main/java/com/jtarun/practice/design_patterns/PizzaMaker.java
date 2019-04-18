package com.jtarun.practice.design_patterns;

interface Pizza {
    int getCost();
    String getDesc();
}

class ThinCrust implements Pizza {
    public int getCost() {
        return 100;
    }

    public String getDesc() {
        return "Thin crust";
    }
}

class Pan implements Pizza {
    public int getCost() {
        return 80;
    }

    public String getDesc() {
        return "Pan Base";
    }
}

abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;
    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
}

class Cheese extends PizzaDecorator {
    public Cheese(Pizza pizza) {
        super(pizza);
    }

    public int getCost() {
        return 20 + pizza.getCost();
    }

    public String getDesc() {
        return pizza.getDesc() + ", cheese";
    }
}

class Paneer extends PizzaDecorator {
    public Paneer(Pizza pizza) {
        super(pizza);
    }

    public int getCost() {
        return 40 + pizza.getCost();
    }

    public String getDesc() {
        return pizza.getDesc() + ", paneer";
    }
}

class Chicken extends PizzaDecorator {
    public Chicken(Pizza pizza) {
        super(pizza);
    }

    public int getCost() {
        return 60 + pizza.getCost();
    }

    public String getDesc() {
        return pizza.getDesc() + ", chicken";
    }
}

public class PizzaMaker {

    public static void main(String[] args) {
        Pizza panNonVezPizza = new Chicken(new Pan());
        Pizza thinCrustVezPizza = new Paneer(new Cheese(new ThinCrust()));

        System.out.println("-------------Non Veg---------------");
        System.out.println(panNonVezPizza.getCost());
        System.out.println(panNonVezPizza.getDesc());
        System.out.println("-------------Non Veg---------------");

        System.out.println("-------------Veg-------------------");
        System.out.println(thinCrustVezPizza.getCost());
        System.out.println(thinCrustVezPizza.getDesc());
        System.out.println("-------------Veg-------------------");

    }

}
