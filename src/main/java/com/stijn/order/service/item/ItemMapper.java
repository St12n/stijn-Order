package com.stijn.order.service.item;

import com.stijn.order.domain.item.Item;
import com.stijn.order.domain.item.fields.Price;
import com.stijn.order.domain.item.fields.PriceCurrency;
import com.stijn.order.domain.item.fields.StockAmount;
import com.stijn.order.domain.item.fields.StockUnit;
import com.stijn.order.service.item.dto.CreateItemDTO;
import com.stijn.order.service.item.dto.ItemDTO;

public class ItemMapper {
    public Item mapCreateItemDTOToItem(CreateItemDTO createItemDTO) {
        return new Item(createItemDTO.getName(),
                createItemDTO.getDescription(),
                new Price(Double.parseDouble(createItemDTO.getPriceAmount()), PriceCurrency.valueOf(createItemDTO.getPriceCurrency())),
                new StockAmount(Double.parseDouble(createItemDTO.getStockAmount()), StockUnit.valueOf(createItemDTO.getStockUnit())));
    }

    public ItemDTO mapItemToItemDTO(Item item){
        return new ItemDTO()
                .setName(item.getName())
                .setDescription(item.getDescription())
                .setAmount(item.getAmount().toString())
                .setPrice(item.getPrice().toString());
    }
}
