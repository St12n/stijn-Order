package com.stijn.order.service.item.dto;

public class ItemDTO {
    private String name;
    private String description;
    private String price;
    private String amount;

    public String getName() {
        return name;
    }

    public ItemDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public ItemDTO setPrice(String price) {
        this.price = price;
        return this;
    }

    public String getAmount() {
        return amount;
    }

    public ItemDTO setAmount(String amount) {
        this.amount = amount;
        return this;
    }
}
