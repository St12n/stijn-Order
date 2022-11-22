package com.stijn.order.domain.order;

import com.stijn.order.domain.item.price.Price;
import com.stijn.order.domain.user.User;

import java.util.List;
import java.util.UUID;

public class Order {
    private final String orderID;
    private final List<ItemGroup> itemGroupList;
    private final Price totalPrice;
    private final User user;

    public Order(List<ItemGroup> itemGroupList, Price totalPrice, User user) {
        this.orderID = UUID.randomUUID().toString();
        this.itemGroupList = itemGroupList;
        this.totalPrice = totalPrice;
        this.user = user;
    }

    public String getOrderID() {
        return orderID;
    }

    public List<ItemGroup> getItemGroupList() {
        return itemGroupList;
    }

    public Price getTotalPrice() {
        return totalPrice;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", itemGroupList=" + itemGroupList +
                ", totalPrice=" + totalPrice +
                ", user=" + user +
                '}';
    }
}
