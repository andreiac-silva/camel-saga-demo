package com.saga.flight.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "flight_reservation")
public class FlightReservation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "customer_id", nullable = false)
	private Long customerId;

	@Column(name = "order_code", nullable = false)
	private String orderCode;

	@JoinColumn(name = "seat_id")
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Seat seat;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private Status status;

	public FlightReservation() {
		this.status = Status.OK;
	}

	public FlightReservation(Long customerId, Seat seat, String orderCode) {
		this.customerId = customerId;
		this.orderCode = orderCode;
		this.seat = seat;
		book();
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

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	private void book() {
		this.seat.changeToUnavailable();
		this.status = Status.OK;
	}

	public void cancelRerservation() {
		this.status = Status.CANCELLED;
		this.seat.changeToAvailable();
	}

	public enum Status {
		OK, CANCELLED
	}
}
