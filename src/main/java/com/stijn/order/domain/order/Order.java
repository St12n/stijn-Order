package com.stijn.order.domain.order;

import com.stijn.order.domain.item.price.Price;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @Column(name = "ORDER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @SequenceGenerator(name = "order_seq", sequenceName = "order_seq", allocationSize = 1)
    private Long orderID;

    @OneToMany
    @JoinTable(name = "fk_order")
    private List<ItemGroup> itemGroupList;
    private Price totalPrice;

    public Order(List<ItemGroup> itemGroupList, Price totalPrice) {
        this.itemGroupList = itemGroupList;
        this.totalPrice = totalPrice;
    }

   public List<ItemGroup> getItemGroupList() {
        return itemGroupList;
    }

    public Price getTotalPrice() {
        return totalPrice;
    }


    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", itemGroupList=" + itemGroupList +
                ", totalPrice=" + totalPrice +
                ", user=" +
                '}';
    }
}
