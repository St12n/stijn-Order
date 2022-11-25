package com.stijn.order.domain.order;

import com.stijn.order.domain.item.price.Price;
import com.stijn.order.domain.item.price.PriceCurrency;


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

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_ORDER_ID")
    private List<ItemGroup> itemGroupList;

    @Embedded
    private Price totalPrice;

    public Order() {
    }

    public Order(List<ItemGroup> itemGroupList) {
        this.itemGroupList = itemGroupList;
        this.totalPrice = itemGroupList.stream()
                .map(item -> item.getPrice())
                .reduce(new Price(0, PriceCurrency.EUR),(p1, p2) -> new Price(p1.getPriceAmount() + p2.getPriceAmount(),p1.getPriceCurrency()));
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
