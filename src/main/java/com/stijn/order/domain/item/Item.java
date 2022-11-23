package com.stijn.order.domain.item;

import com.stijn.order.domain.item.price.Price;
import com.stijn.order.domain.item.stockAmount.StockAmount;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    @Column(name = "ITEM_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
    @SequenceGenerator(name = "item_seq", sequenceName = "item_seq", allocationSize = 1)
    private Long itemId;
    @Column(name = "ITEM_NAME")
    private String name;
    @Column(name = "ITEM_DESCRIPTION")
    private String description;
    @Embedded
    private Price price;
    @Embedded
    private StockAmount amount;

    public Item() {
    }

    public Item(String name, String description, Price price, StockAmount amount) {
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
                "ItemId='" + itemId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
