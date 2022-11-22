package com.stijn.order.domain.item;

import com.stijn.order.domain.item.price.Price;
import com.stijn.order.domain.item.stockAmount.StockAmount;

import java.util.UUID;

public class Item {
    private final String ItemId;
    private final String name;
    private final String description;
    private final Price price;
    private final StockAmount amount;

    public Item(String name, String description, Price price, StockAmount amount) {
        this.ItemId = UUID.randomUUID().toString();
        this.name = verifyNameOrDescription(name);
        this.description = verifyNameOrDescription(description);
        this.price = verifyPrice(price);
        this.amount = verifyStockAmount(amount);
    }

    private String verifyNameOrDescription(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Provide a name and a description for the item");
        }
        return input;
    }

    private StockAmount verifyStockAmount(StockAmount stockAmount) {
        if (stockAmount == null) {
            throw new IllegalArgumentException("Stock amount cannot be null.");
        }
        return stockAmount;
    }

    private Price verifyPrice(Price price) {
        if (price == null) {
            throw new IllegalArgumentException("Price cannot be null.");
        }
        return price;
    }

    public String getItemId() {
        return ItemId;
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

    @Override
    public String toString() {
        return "Item{" +
                "ItemId='" + ItemId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
