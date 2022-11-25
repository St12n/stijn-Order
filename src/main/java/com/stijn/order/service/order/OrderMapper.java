package com.stijn.order.service.order;

import com.stijn.order.domain.order.Order;
import com.stijn.order.service.order.dto.CreateOrderDTO;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    private final ItemGroupMapper itemGroupMapper;

    public OrderMapper(ItemGroupMapper itemGroupMapper) {
        this.itemGroupMapper = itemGroupMapper;
    }

    public Order mapCreateOrderDTOToOrder(CreateOrderDTO createOrderDTO) {
        return new Order(
                itemGroupMapper.mapListOfCreateItemGroupDTOToListOfItemGroup(createOrderDTO.getListOfItemGroups())
        );
    }
}
