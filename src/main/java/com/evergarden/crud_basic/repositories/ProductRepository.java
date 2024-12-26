package com.evergarden.crud_basic.repositories;

import com.evergarden.crud_basic.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
