package com.example.homework3;

public class Lollipop extends Sweet{
    private String taste;

    public Lollipop(String name, double weight, double price, String taste) {
        super(name, weight, price);
        this.taste = taste;
    }

    @Override
    public String uniqueParam() {
        return taste;
    }






}
