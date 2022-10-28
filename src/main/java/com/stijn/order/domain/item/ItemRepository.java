package com.stijn.order.domain.item;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ItemRepository {

    private final Logger log = LoggerFactory.getLogger(ItemRepository.class);

    private final Map<String, Item> itemRepositoryByID;

    public ItemRepository() {
        this.itemRepositoryByID = new HashMap<>();
    }

    public void saveItemToRepo(Item item) {
        itemRepositoryByID.put(item.getItemId(), item);
        log.info("POST -> ".concat(item.toString()));
    }
}
