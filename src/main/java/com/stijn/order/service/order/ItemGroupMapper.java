package com.stijn.order.service.order;

import com.stijn.order.domain.item.price.Price;
import com.stijn.order.domain.item.price.PriceCurrency;
import com.stijn.order.domain.order.ItemGroup;
import com.stijn.order.repositories.ItemRepository;
import com.stijn.order.service.order.dto.CreateItemGroupDTO;
import com.stijn.order.service.order.dto.ReturnItemGroupDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemGroupMapper {

    private ItemRepository itemRepository;

    public ItemGroupMapper(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemGroup itemGroupDtoToItemGroup(CreateItemGroupDTO createItemGroupDTO) {
        return new ItemGroup(
                createItemGroupDTO.getItemID(),
                createItemGroupDTO.getAmount(),
                itemRepository.findItemByItemId(createItemGroupDTO.getItemID()).getPrice()
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

}
