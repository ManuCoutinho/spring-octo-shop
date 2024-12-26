package com.evergarden.crud_basic.repositories;


import com.evergarden.crud_basic.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Long> {
}
