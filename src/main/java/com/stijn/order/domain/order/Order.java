package com.stijn.order.domain.order;

import com.stijn.order.domain.item.price.Price;
import javax.persistence.*;
import java.util.List;
import static com.stijn.order.domain.item.price.Price.eur;

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
//        this.totalPrice = calculateTotalPrice(itemGroupList);
        this.totalPrice = itemGroupList.stream()
                .map(item -> item.getPrice())
                .reduce(eur(0), (p1, p2) -> p1.add(p2));
    }

//    private Price calculateTotalPrice(List<ItemGroup> itemGroupList) {
//        double priceAmount = 0;
//        for (ItemGroup itemGroup : itemGroupList) {
//            priceAmount = priceAmount + itemGroup.getPrice().getPriceAmount();
//        }
//        return new Price(priceAmount, PriceCurrency.EUR);
//    }

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
