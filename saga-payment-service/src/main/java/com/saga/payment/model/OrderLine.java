package com.saga.payment.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderLine implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "quantity", nullable = false)
	private Integer quantity;

	@Column(name = "amount_of_miles", nullable = false)
	private BigInteger amountOfMiles;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_order")
	private Order order;

	public OrderLine() {
	}

	public OrderLine(Integer quantity, BigInteger amountOfMiles, Order order) {
		this.quantity = quantity;
		this.amountOfMiles = amountOfMiles;
		this.order = order;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public BigInteger getTotal() {
		return this.amountOfMiles.multiply(BigInteger.valueOf(this.quantity));
	}
}
