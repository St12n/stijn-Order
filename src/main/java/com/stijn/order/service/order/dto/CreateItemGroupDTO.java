package com.stijn.order.service.order.dto;

import com.stijn.order.domain.item.stockAmount.StockAmount;

public class CreateItemGroupDTO {
    private Long itemID;
    private StockAmount amount;


    public CreateItemGroupDTO(Long itemID, StockAmount amount) {
        this.itemID = itemID;
        this.amount = amount;
    }

    public Long getItemID() {
        return itemID;
    }

    public StockAmount getAmount() {
        return amount;
    }
}
