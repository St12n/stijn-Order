package com.stijn.order.domain.order;

import com.google.common.collect.Lists;
import com.stijn.order.domain.item.price.Price;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.stijn.order.domain.item.price.Price.eur;


class OrderTest {

    @Test
    void name() {
        Order order = new Order(
                Lists.newArrayList(
                        new ItemGroup(null, null, eur(10)),
                        new ItemGroup(null, null, eur(10)),
                        new ItemGroup(null, null, eur(10)),
                        new ItemGroup(null, null, eur(10)),
                        new ItemGroup(null, null, eur(10)),
                        new ItemGroup(null, null, eur(10))
                ));

        Assertions.assertThat(order.getTotalPrice()).isEqualTo(eur(60));
    }
}