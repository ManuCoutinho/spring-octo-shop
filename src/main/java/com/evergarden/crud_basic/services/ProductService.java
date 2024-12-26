package com.evergarden.crud_basic.services;

import com.evergarden.crud_basic.entities.Product;
import com.evergarden.crud_basic.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
	@Autowired
	ProductRepository repository;

	public List<Product> getAll() {
		return repository.findAll();
	}

	public Product findById(Long id){
		Optional<Product> obj = repository.findById(id);
		return obj.orElse(null);
	}
}
