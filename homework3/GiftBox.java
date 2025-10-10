package com.example.homework3;

import java.util.ArrayList;

public class GiftBox implements SweetBox {


    private ArrayList<Sweet> sweets;


    public GiftBox() {
        sweets = new ArrayList<>();
    }


    @Override
    public void addSweet(Sweet sweet) {
        sweets.add(sweet);
    }


    @Override
    public void removeSweet(int index) {
        if (index >= 0 && index < sweets.size()) {
            sweets.remove(index);
        } else {
            System.out.println("Неверный индекс!");
        }
    }


    @Override
    public void removeLastSweet() {
        if (!sweets.isEmpty()) {
            sweets.remove(sweets.size() - 1);
        } else {
            System.out.println("Коробка пустая!");
        }
    }


    @Override
    public double getTotalWeight() {
        double total = 0;
        for (Sweet s : sweets) {
            total += s.getWeight();
        }
        return total;
    }


    @Override
    public double getTotalPrice() {
        double total = 0;
        for (Sweet s : sweets) {
            total += s.getPrice();
        }
        return total;
    }


    @Override
    public void printAllSweets() {
        for (Sweet s : sweets) {
            System.out.println(s);
        }
    }


    @Override
    public void optimizeByWeight(double targetWeight) {
        while (getTotalWeight() > targetWeight && !sweets.isEmpty()) {
            // Находим сладость с минимальным весом
            Sweet minSweet = sweets.get(0);
            for (Sweet s : sweets) {
                if (s.getWeight() < minSweet.getWeight()) {
                    minSweet = s;
                }
            }
            sweets.remove(minSweet);
        }
    }


    @Override
    public void optimizeByPrice(double targetWeight) {
        while (getTotalWeight() > targetWeight && !sweets.isEmpty()) {

            Sweet minSweet = sweets.get(0);
            for (Sweet s : sweets) {
                if (s.getPrice() < minSweet.getPrice()) {
                    minSweet = s;
                }
            }
            sweets.remove(minSweet);
        }
    }
}

