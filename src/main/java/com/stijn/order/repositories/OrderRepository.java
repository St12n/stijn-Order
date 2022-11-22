package com.stijn.order.repositories;

import com.stijn.order.domain.order.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderRepository {

    private final Logger log = LoggerFactory.getLogger(OrderRepository.class);
    private final Map<String, Order> orderRepositoryByID;

    public OrderRepository() {
        this.orderRepositoryByID = new HashMap<>();
    }

    public void saveOrderToRepository(Order order) {
        orderRepositoryByID.put(order.getOrderID(), order);
        log.info("POST ->".concat(order.toString()));
    }

    public Order findOrderByID(String orderID) {
        return orderRepositoryByID.get(orderID);
    }


}
