package com.saga.payment.model.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saga.payment.exception.FlightNoRegisteredException;
import com.saga.payment.exception.HotelNotRegisteredException;
import com.saga.payment.exception.NumberOfGuestsNotAllowed;
import com.saga.payment.model.FlightMilesCost;
import com.saga.payment.model.HotelRoomMilesCost;
import com.saga.payment.model.HotelRoomMilesCost.Type;
import com.saga.payment.model.Order;
import com.saga.payment.model.OrderLine;
import com.saga.payment.model.repository.FlightMilesCostRepository;
import com.saga.payment.model.repository.HotelRoomMilesCostRepository;

@Service
public class OrderLineService {

	@Autowired
	private HotelRoomMilesCostRepository hotelRoomMilesCostRepository;

	@Autowired
	private FlightMilesCostRepository flightMilesCostRepository;

	public OrderLine createHotelOrderLine(final String hotelCode, final Order order, final Integer numberOfGuests)
			throws NumberOfGuestsNotAllowed, HotelNotRegisteredException {

		HotelRoomMilesCost hotelMilesCost = this.hotelRoomMilesCostRepository.findFirstByCodeAndType(hotelCode,
				Type.findByNumberOfVacancies(numberOfGuests));

		if (hotelMilesCost == null) {
			throw new HotelNotRegisteredException();
		}

		return new OrderLine(1, hotelMilesCost.getCostInMiles(), order);
	}

	@Transactional
	public OrderLine createFlightOrderLine(final String code, final Order order, final Integer numberOfPassengers)
			throws FlightNoRegisteredException {

		FlightMilesCost flightMilesCost = this.flightMilesCostRepository.findFirstByCode(code);

		if (flightMilesCost == null) {
			throw new FlightNoRegisteredException();
		}

		return new OrderLine(numberOfPassengers, flightMilesCost.getCostInMiles(), order);
	}
}
