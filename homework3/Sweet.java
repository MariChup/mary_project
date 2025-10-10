package com.example.homework3;

public abstract class Sweet {
    private String name;
    private double weight;
    private double price;

    public Sweet(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public double getWeight() {
        return weight;
    }

    public abstract String uniqueParam();

    @Override
    public String toString() {
        return "Название: " + getName() +
                ", Вес: " + getWeight() +
                ", Цена: " + getPrice() +
                ", " + uniqueParam();
    }

}
