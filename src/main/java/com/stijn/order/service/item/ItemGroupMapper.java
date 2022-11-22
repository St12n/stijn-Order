package com.stijn.order.service.item;

import com.stijn.order.domain.item.price.Price;
import com.stijn.order.domain.item.price.PriceCurrency;
import com.stijn.order.domain.order.ItemGroup;
import com.stijn.order.repositories.ItemRepository;
import com.stijn.order.service.order.dto.CreateItemGroupDTO;
import com.stijn.order.service.order.dto.ReturnItemGroupDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ItemGroupMapper {

    private ItemRepository itemRepository;

    public ItemGroupMapper() {
        this.itemRepository = new ItemRepository();
    }

    public ItemGroup itemGroupDtoToItemGroup(CreateItemGroupDTO createItemGroupDTO) {
        return new ItemGroup(
                createItemGroupDTO.getItemID(),
                createItemGroupDTO.getAmount(),
                itemRepository.findItemByItemID(createItemGroupDTO.getItemID()).getPrice()
        );
    }

    public ReturnItemGroupDTO itemGroupToReturnItemGroupDTO(ItemGroup itemGroup) {
        return new ReturnItemGroupDTO(
                itemGroup.getItemID(),
                itemGroup.getAmount(),
                itemGroup.getShippingDate(),
                itemGroup.getPrice());
    }

    public List<ItemGroup> mapListOfCreateItemGroupDTOToListOfItemGroup(List<CreateItemGroupDTO> createItemGroupDTOList) {
        return createItemGroupDTOList.stream()
                .map(this::itemGroupDtoToItemGroup)
                .collect(Collectors.toList());
    }

    public Price mapListOfCreateItemGroupDTOToPrice(List<CreateItemGroupDTO> createItemGroupDTOList) {
        double total = 0;
        List<Price> priceList = createItemGroupDTOList.stream()
                .map(dto -> itemRepository.findItemByItemID(dto.getItemID()).getPrice())
                .toList();

        for (Price price : priceList) {
            total += price.getPriceAmount();
        }
        return new Price(total, PriceCurrency.EUR);
    }

}
