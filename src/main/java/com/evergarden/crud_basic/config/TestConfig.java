package com.evergarden.crud_basic.config;

import com.evergarden.crud_basic.entities.*;
import com.evergarden.crud_basic.entities.enums.OrderStatus;
import com.evergarden.crud_basic.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
@Autowired
	private UserRepository userRepository;
@Autowired
private OrderRepository orderRepository;

@Autowired
private CategoryRepository categoryRepository;

@Autowired
	private ProductRepository productRepository;

@Autowired
private OrderItemRepository orderItemRepository;


	@Override
	public void run(String... args) throws Exception {
		Product p1 = new Product(null, "Senhor dos Aneis", "Livro 1 da série", 59.90, "url");
		Product p2 = new Product(null, "Iphone 16", "Smartphone", 8999.99, "url");
		Product p3 = new Product(null, "Ideapad", "Tablet", 2999.99, "url");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		User u1 = new User(null, "Jane Doe", "jane@email.com", "22222222", "senha");
		User u2 = new User(null, "John Doe", "john@email.com", "22222226", "password");

		Order o1 = new Order(null, Instant.parse("2024-06-20T19:53:07Z"), OrderStatus.DELIVERED, u1);
		Order o2 = new Order(null, Instant.parse("2024-07-21T03:42:10Z"), OrderStatus.CANCELED, u2);
		Order o3 = new Order(null, Instant.parse("2024-07-22T15:21:22Z"), OrderStatus.PAID, u1);

		Category category1 = new Category(null, "Electronics");
		Category category2 = new Category(null, "Books");
		Category category3 = new Category(null, "Cloths");


		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

		productRepository.saveAll(Arrays.asList(p1,p2, p3, p4, p5));
		categoryRepository.saveAll((Arrays.asList(category1, category2, category3)));
		p1.getCategories().add(category2);
		p2.getCategories().add(category1);
		p3.getCategories().add(category1);
		p4.getCategories().add(category3);
		p5.getCategories().add(category2);

		productRepository.saveAll(Arrays.asList(p1,p2, p3, p4, p5));
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

		Payment pay1 = new Payment(null, Instant.parse("2024-07-22T15:23:25Z"), o1);
		o1.setPayment(pay1);
		orderRepository.save(o1);

	}
}
