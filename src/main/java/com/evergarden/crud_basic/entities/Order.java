package com.evergarden.crud_basic.entities;

import com.evergarden.crud_basic.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;

	private Integer status;
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();

	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;

	public Order(Long id, Instant moment, OrderStatus status, User client) {
		this.id = id;
		this.moment = moment;
		setStatus(status);
		this.client = client;
	}

	public Order() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setStatus(OrderStatus status) {
		if (status != null) {
			this.status = status.getCode();
		}
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public OrderStatus getStatus() {
		return OrderStatus.valueOf(status);
	}

	public void setClient(User client) {
		this.client = client;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Double getTotal() {
		double sum = 0.0;
		for (OrderItem item : items) {
			sum += item.getSubTotal();
		}
		return sum;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Order order))
			return false;
		return Objects.equals(getId(), order.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

}
