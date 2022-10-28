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

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Price getPrice() {
        return price;
    }

    public StockAmount getAmount() {
        return amount;
    }
}
