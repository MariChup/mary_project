package com.example.homework3;

public class Cookie extends Sweet{

    private String type;

    public Cookie(String name, double weight, double price, String type) {
        super(name, weight, price);
        this.type = type;
    }

    @Override
    public String uniqueParam() {
        return type;
    }

}
