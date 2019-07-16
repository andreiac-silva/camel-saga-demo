package com.saga.hotel.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saga.hotel.exception.NumberOfGuestsNotAllowed;
import com.saga.hotel.exception.RoomNotAvailableException;
import com.saga.hotel.model.HotelReservation;
import com.saga.hotel.model.Room;
import com.saga.hotel.repository.HotelReservationRepository;

@Service
public class HotelReservationService {

	@Autowired
	private HotelReservationRepository repository;

	@Autowired
	private RoomService roomService;

	@Transactional
	public void bookHotel(final Long customerId, final Integer numberOfGuests, final String orderCode,
			final String hotelCode) throws RoomNotAvailableException, NumberOfGuestsNotAllowed {

		Room room = this.roomService.findFisrtAvailableRoom(hotelCode, numberOfGuests);
		this.repository.save(new HotelReservation(customerId, orderCode, room));
	}

	/**
	 * Compensating local transaction
	 * 
	 * @param orderCode: Saga id to is used to identify the order.
	 */
	public void cancelHotelScheduling(final String orderCode) {

		HotelReservation hotelReservation = this.repository.findByOrderCode(orderCode);

		if (hotelReservation == null) {
			return;
		}

		hotelReservation.cancelRerservation();
		this.repository.save(hotelReservation);
	}
}
