package com.evergarden.crud_basic.repositories;

import com.evergarden.crud_basic.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
