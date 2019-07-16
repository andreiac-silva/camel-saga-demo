package com.saga.hotel.exception;

public class NumberOfGuestsNotAllowed extends Exception {

	private static final long serialVersionUID = 1L;

	public NumberOfGuestsNotAllowed() {
		super("Number of guests not allowed. Please select a number between 1 and 4.");
	}
}
