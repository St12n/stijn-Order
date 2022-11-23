package com.stijn.order.service.order;

import com.stijn.order.domain.order.Order;
import com.stijn.order.repositories.UserRepository;
import com.stijn.order.service.item.ItemGroupMapper;
import com.stijn.order.service.order.dto.CreateOrderDTO;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    private final UserRepository userRepository;
    private final ItemGroupMapper itemGroupMapper;

    public OrderMapper(UserRepository userRepository, ItemGroupMapper itemGroupMapper) {
        this.userRepository = userRepository;
        this.itemGroupMapper = itemGroupMapper;
    }

    public Order mapCreateOrderDTOToOrder(CreateOrderDTO createOrderDTO) {
        return new Order(
                itemGroupMapper.mapListOfCreateItemGroupDTOToListOfItemGroup(createOrderDTO.getListOfItemGroups()),
                itemGroupMapper.mapListOfCreateItemGroupDTOToPrice(createOrderDTO.getListOfItemGroups()),
                userRepository.findUserByEmail(createOrderDTO.getUserEmail())
        );
    }
}
