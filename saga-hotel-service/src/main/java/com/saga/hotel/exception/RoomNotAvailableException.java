package com.saga.hotel.exception;

public class RoomNotAvailableException extends Exception {

	private static final long serialVersionUID = 1L;

	public RoomNotAvailableException() {
		super("There are not vailable rooms");
	}
}
