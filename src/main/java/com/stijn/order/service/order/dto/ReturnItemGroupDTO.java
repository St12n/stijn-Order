package com.stijn.order.service.order.dto;

import com.stijn.order.domain.item.price.Price;
import com.stijn.order.domain.item.stockAmount.StockAmount;

import java.time.LocalDate;

public class ReturnItemGroupDTO {
    private final Long itemID;
    private final StockAmount amount;
    private final LocalDate shippingDate;
    private final Price price;

    public ReturnItemGroupDTO(Long itemID, StockAmount amount, LocalDate shippingDate, Price price) {
        this.itemID = itemID;
        this.amount = amount;
        this.shippingDate = shippingDate;
        this.price = price;
    }

    public Long getItemID() {
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
