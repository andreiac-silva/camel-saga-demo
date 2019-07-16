package com.saga.payment.exception;

public class FlightNoRegisteredException extends Exception {

	private static final long serialVersionUID = 1L;

	public FlightNoRegisteredException() {
		super("Flight not registered");
	}

}
