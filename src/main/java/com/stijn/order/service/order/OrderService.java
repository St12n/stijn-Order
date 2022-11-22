package com.stijn.order.service.order;

import com.stijn.order.repositories.OrderRepository;
import com.stijn.order.service.item.dto.ItemDTO;
import com.stijn.order.service.order.dto.CreateOrderDTO;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.orderMapper = new OrderMapper();
    }


    //todo: implement order -> dto's, mapper and service.
    public ItemDTO saveOrder(CreateOrderDTO createOrderDTO) {
        return null;
    }
}
