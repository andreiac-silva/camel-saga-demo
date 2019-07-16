package com.saga.flight.exception;

public class UnavailableNumberOfSeatsException extends Exception {

	private static final long serialVersionUID = 1L;

	public UnavailableNumberOfSeatsException() {
		super("There are not enough seats available");
	}
}
