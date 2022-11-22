package com.stijn.order.service.item.dto;

public class CreateItemDTO {
    private String name;
    private String description;
    private String priceAmount;
    private String priceCurrency;
    private String stockAmount;
    private String stockUnit;


    public String getName() {
        return name;
    }

    public CreateItemDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CreateItemDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPriceAmount() {
        return priceAmount;
    }

    public CreateItemDTO setPriceAmount(String priceAmount) {
        this.priceAmount = priceAmount;
        return this;
    }

    public String getPriceCurrency() {
        return priceCurrency;
    }

    public CreateItemDTO setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
        return this;
    }

    public String getStockAmount() {
        return stockAmount;
    }

    public CreateItemDTO setStockAmount(String stockAmount) {
        this.stockAmount = stockAmount;
        return this;
    }

    public String getStockUnit() {
        return stockUnit;
    }

    public CreateItemDTO setStockUnit(String stockUnit) {
        this.stockUnit = stockUnit;
        return this;
    }
}
