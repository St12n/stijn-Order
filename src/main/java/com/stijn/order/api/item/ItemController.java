package com.stijn.order.api.item;

import com.stijn.order.api.user.UserController;
import com.stijn.order.service.item.ItemService;
import com.stijn.order.service.item.dto.CreateItemDTO;
import com.stijn.order.service.item.dto.ItemDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/items")
public class ItemController {
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO saveItem(@RequestBody CreateItemDTO createItemDTO) {
        log.info("POST -> ItemController post a new item");
        return itemService.saveItem(createItemDTO);
    }
}
