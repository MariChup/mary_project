package com.example.homework3;

public class Chocolate extends Sweet{
    private String cacao;

    public Chocolate(String name, double weight, double price, String cacao) {
        super(name, weight, price);
        this.cacao = cacao;
    }

    @Override
    public String uniqueParam() {
        return cacao;
    }
}
