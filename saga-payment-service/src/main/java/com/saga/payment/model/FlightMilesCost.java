package com.saga.payment.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "flight_miles_cost")
public class FlightMilesCost extends MilesCost {

	private static final long serialVersionUID = 1L;
}
