package com.stijn.order.domain.order;

import com.stijn.order.domain.item.price.Price;
import com.stijn.order.domain.item.stockAmount.StockAmount;

import java.time.LocalDate;

public class ItemGroup {

    private final String itemID;
    private final StockAmount amount;
    private final LocalDate shippingDate;
    private final Price price;

    public ItemGroup(String itemID, StockAmount amount, Price price) {
        this.itemID = itemID;
        this.amount = amount;
        this.price = price;
        this.shippingDate = LocalDate.now().plusDays(1);
    }

    public String getItemID() {
        return itemID;
    }

    public StockAmount getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public Price getPrice() {
        return price;
    }

}
