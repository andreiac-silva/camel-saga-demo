package com.saga.payment.exception;

public class HotelNotRegisteredException extends Exception {

	private static final long serialVersionUID = 1L;

	public HotelNotRegisteredException() {
		super("Hotel not registered");
	}
}
