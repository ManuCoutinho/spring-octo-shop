package com.evergarden.crud_basic.services;

import com.evergarden.crud_basic.entities.Order;
import com.evergarden.crud_basic.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;
	public List<Order> findAll() {
		return repository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.orElse(null);
	}
}
