package com.saga.payment.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_miles")
public class CustomerMiles implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "customer_id", nullable = false, unique = true)
	private Long customerId;

	@Column(name = "amount_of_miles", nullable = false)
	private BigInteger amountOfMiles;

	public CustomerMiles() {
	}

	public CustomerMiles(Long customerId, BigInteger amountOfMiles) {
		this.customerId = customerId;
		this.amountOfMiles = amountOfMiles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public BigInteger getAmountOfMiles() {
		return amountOfMiles;
	}

	public void setAmountOfMiles(BigInteger amountOfMiles) {
		this.amountOfMiles = amountOfMiles;
	}

	public void addMmiles(final BigInteger miles) {
		this.amountOfMiles.add(miles);
	}

	public void subtractMiles(final BigInteger miles) {
		this.amountOfMiles.subtract(miles);
	}
}
