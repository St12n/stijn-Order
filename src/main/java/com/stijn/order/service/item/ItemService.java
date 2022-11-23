package com.stijn.order.service.item;

import com.stijn.order.domain.item.Item;
import com.stijn.order.repositories.ItemRepository;
import com.stijn.order.service.item.dto.CreateItemDTO;
import com.stijn.order.service.item.dto.ItemDTO;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
        this.itemMapper = new ItemMapper();
    }

    public ItemDTO saveItem(CreateItemDTO createItemDTO) {
        Item newItem = itemMapper.mapCreateItemDTOToItem(createItemDTO);
        itemRepository.save(newItem);
        return itemMapper.mapItemToItemDTO(newItem);
    }
}
