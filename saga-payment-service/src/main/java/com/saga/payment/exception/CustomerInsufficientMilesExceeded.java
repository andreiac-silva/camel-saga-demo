package com.saga.payment.exception;

public class CustomerInsufficientMilesExceeded extends Exception {

	private static final long serialVersionUID = 1L;

	public CustomerInsufficientMilesExceeded() {
		super("Customer does not have sufficient miles for this order");
	}
}
