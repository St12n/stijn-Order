package com.stijn.order.domain.order;

import com.stijn.order.domain.item.Item;
import com.stijn.order.domain.item.ItemRepository;
import com.stijn.order.domain.item.fields.StockAmount;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class ItemGroup {

    @Autowired
    private ItemRepository itemRepository;
    private final String itemID;
    private final StockAmount amount;
    private final LocalDate shippingDate;

    public ItemGroup(String itemID, StockAmount amount) {
        this.itemID = itemID;
        this.amount = amount;
        this.shippingDate = calculateShippingDate(itemID, amount);
    }

    private Item getItemByID(String itemID) {
        return itemRepository.findItemByItemID(itemID);
    }

    private LocalDate calculateShippingDate(String itemID, StockAmount amount) {
        if (getItemByID(itemID) == null) {
            throw new IllegalArgumentException("No item found with ID ".concat(itemID));
        }
        if (getItemByID(itemID).getAmount().getAmountInStock() > amount.getAmountInStock()) {
            return LocalDate.now().plusDays(1);
        }
        return LocalDate.now().plusDays(7);
    }
}
