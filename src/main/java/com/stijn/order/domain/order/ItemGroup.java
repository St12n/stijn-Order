package com.stijn.order.domain.order;

import com.stijn.order.domain.item.price.Price;
import com.stijn.order.domain.item.stockAmount.StockAmount;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ITEMGROUPS")
public class ItemGroup {

    @Id
    @Column(name = "ITEMGROUP_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_group_seq")
    @SequenceGenerator(name = "item_group_seq", sequenceName = "item_group_seq", allocationSize = 1)
    private Long itemGroupID;

    @Column(name = "ORDERED_ITEM_ID")
    private Long itemID;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amountInStock", column = @Column( name = "ORDER_AMOUNT")),
            @AttributeOverride(name = "stockUnit", column = @Column( name = "ORDER_UNIT"))
    })
    private StockAmount amount;

    @Column(name = "SHIPPING_DATE")
    private LocalDate shippingDate;

    @Embedded
    private Price price;

    public ItemGroup() {
    }

    public ItemGroup(Long itemID, StockAmount amount, Price price) {
        this.itemID = itemID;
        this.amount = amount;
        this.price = price;
        this.shippingDate = LocalDate.now().plusDays(1);
    }

    public Long getItemID() {
        return itemID;
    }

    public StockAmount getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public Price getPrice() {
        return price;
    }

    public Long getItemGroupID() {
        return itemGroupID;
    }
}
