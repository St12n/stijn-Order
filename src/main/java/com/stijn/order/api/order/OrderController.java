package com.stijn.order.api.order;

import com.stijn.order.domain.user.role.Feature;
import com.stijn.order.service.item.dto.ItemDTO;
import com.stijn.order.service.order.dto.CreateOrderDTO;
import com.stijn.order.service.security.SecurityService;
import com.stijn.order.service.order.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    private final Logger log = LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;
    private final SecurityService securityService;

    public OrderController(OrderService orderService, SecurityService securityService) {
        this.orderService = orderService;
        this.securityService = securityService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO saveOrder(@RequestHeader String authorization, @RequestBody CreateOrderDTO createOrderDTO) {
        securityService.validateAuthorization(authorization, Feature.ORDER_ITEM);
        log.info("POST -> ItemController post a new item");
        return orderService.saveOrder(createOrderDTO);
    }
}
