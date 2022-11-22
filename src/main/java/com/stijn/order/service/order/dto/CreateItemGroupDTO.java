package com.stijn.order.service.order.dto;

import com.stijn.order.domain.item.stockAmount.StockAmount;

public class CreateItemGroupDTO {
    private String itemID;
    private StockAmount amount;


    public CreateItemGroupDTO(String itemID, StockAmount amount) {
        this.itemID = itemID;
        this.amount = amount;
    }

    public String getItemID() {
        return itemID;
    }

    public StockAmount getAmount() {
        return amount;
    }
}
