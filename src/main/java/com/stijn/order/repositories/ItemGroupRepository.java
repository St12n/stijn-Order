package com.stijn.order.repositories;

import com.stijn.order.domain.order.ItemGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemGroupRepository extends JpaRepository<ItemGroup, Long> {
}
