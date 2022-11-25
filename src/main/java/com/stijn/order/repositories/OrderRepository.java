package com.stijn.order.repositories;

import com.stijn.order.domain.order.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public interface OrderRepository extends JpaRepository <Order, Long> {
}
