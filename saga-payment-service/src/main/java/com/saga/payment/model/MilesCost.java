package com.saga.payment.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class MilesCost implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "code", nullable = false)
	private String code;

	@Column(name = "cost_in_miles", nullable = false)
	private BigInteger costInMiles;

	public MilesCost() {
	}

	public MilesCost(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public BigInteger getCostInMiles() {
		return costInMiles;
	}

	public void setCostInMiles(BigInteger costInMiles) {
		this.costInMiles = costInMiles;
	}

	public void setCost(BigInteger cost) {
		this.costInMiles = cost;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
