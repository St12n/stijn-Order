package com.stijn.order.domain.item;

public class Item {
    private final String name;
    private final String description;
    private Price price;
    private StockAmount amount;

    public Item(String name, String description, Price price, StockAmount amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

}
