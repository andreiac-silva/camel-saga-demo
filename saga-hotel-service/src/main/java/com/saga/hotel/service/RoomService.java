package com.saga.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saga.hotel.exception.NumberOfGuestsNotAllowed;
import com.saga.hotel.exception.RoomNotAvailableException;
import com.saga.hotel.model.Room;
import com.saga.hotel.model.Room.Status;
import com.saga.hotel.model.Room.Type;
import com.saga.hotel.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	private RoomRepository repository;

	public Room findFisrtAvailableRoom(final String hotelCode, final Integer numberOfGuests)
			throws RoomNotAvailableException, NumberOfGuestsNotAllowed {

		Type type = Type.findByNumberOfVacancies(numberOfGuests);
		Room room = this.repository.findFirstByHotelCodeAndStatusAndType(hotelCode, Status.AVAILABLE, type);

		if (room == null) {
			throw new RoomNotAvailableException();
		}

		return room;
	}

}
