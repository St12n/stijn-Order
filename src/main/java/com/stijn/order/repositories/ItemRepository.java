package com.stijn.order.repositories;

import com.stijn.order.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findItemByItemId(Long itemId);
}
