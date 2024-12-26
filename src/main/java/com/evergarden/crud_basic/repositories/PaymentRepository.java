package com.evergarden.crud_basic.repositories;

import com.evergarden.crud_basic.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
