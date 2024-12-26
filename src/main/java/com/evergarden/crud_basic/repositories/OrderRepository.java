package com.evergarden.crud_basic.repositories;

import com.evergarden.crud_basic.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
