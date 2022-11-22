package com.stijn.order.service.order;

import com.stijn.order.domain.order.Order;
import com.stijn.order.repositories.UserRepository;
import com.stijn.order.service.item.ItemGroupMapper;
import com.stijn.order.service.order.dto.CreateOrderDTO;

public class OrderMapper {

    UserRepository userRepository = new UserRepository();
    ItemGroupMapper itemGroupMapper = new ItemGroupMapper();

    public Order mapCreateOrderDTOToOrder(CreateOrderDTO createOrderDTO) {
        return new Order(
                itemGroupMapper.mapListOfCreateItemGroupDTOToListOfItemGroup(createOrderDTO.getListOfItemGroups()),
                itemGroupMapper.mapListOfCreateItemGroupDTOToPrice(createOrderDTO.getListOfItemGroups()),
                userRepository.getUserByEmail(createOrderDTO.getUserEmail())
        );
    }
}
