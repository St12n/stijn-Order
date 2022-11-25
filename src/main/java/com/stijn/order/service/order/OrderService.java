package com.stijn.order.service.order;

import com.stijn.order.domain.order.ItemGroup;
import com.stijn.order.domain.order.Order;
import com.stijn.order.repositories.ItemGroupRepository;
import com.stijn.order.repositories.ItemRepository;
import com.stijn.order.repositories.OrderRepository;
import com.stijn.order.service.item.dto.ItemDTO;
import com.stijn.order.service.order.dto.CreateOrderDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ItemRepository itemRepository;
    private final ItemGroupRepository itemGroupRepository;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper, ItemRepository itemRepository, ItemGroupRepository itemGroupRepository) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.itemRepository = itemRepository;
        this.itemGroupRepository = itemGroupRepository;
    }


    //todo: implement order -> dto's, mapper and service.
    public ItemDTO saveOrder(CreateOrderDTO createOrderDTO) {
        Order orderToSave = orderMapper.mapCreateOrderDTOToOrder(createOrderDTO);
        orderRepository.save(orderToSave);
        return null;
    }
}
