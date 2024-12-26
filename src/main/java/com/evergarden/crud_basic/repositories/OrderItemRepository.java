package com.evergarden.crud_basic.repositories;


import com.evergarden.crud_basic.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
