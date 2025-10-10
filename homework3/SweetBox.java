package com.example.homework3;

public interface SweetBox {

    void addSweet(Sweet sweet);


    void removeSweet(int index);


    void removeLastSweet();


    double getTotalWeight();


    double getTotalPrice();


    void printAllSweets();


    void optimizeByWeight(double targetWeight);


    void optimizeByPrice(double targetWeight);
}
