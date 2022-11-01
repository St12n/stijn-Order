package com.stijn.order.domain.order;

import com.stijn.order.domain.user.User;

import java.util.List;

public class Order {
    private final List<ItemGroup> itemGroupList;
    private final double totalPrice;
    private final User user;

    public Order(List<ItemGroup> itemGroupList, double totalPrice, User user) {
        this.itemGroupList = itemGroupList;
        this.totalPrice = totalPrice;
        this.user = user;
    }
}
