package com.saga.flight.service;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saga.flight.exception.UnavailableNumberOfSeatsException;
import com.saga.flight.model.FlightReservation;
import com.saga.flight.repository.FlightReservationRepository;

@Service
public class FlightReservationService {

	@Autowired
	private FlightReservationRepository repository;

	@Autowired
	private SeatService seatService;

	@Transactional
	public void bookFlight(final Long customerId, final Integer numberOfSeats, final String orderCode,
			final String flightCode) throws UnavailableNumberOfSeatsException {

		List<FlightReservation> reservations = new ArrayList<>();
		
		this.seatService.findAvailableSeatsByFlightCode(numberOfSeats, flightCode)
				.forEach(seat -> reservations.add(new FlightReservation(customerId, seat, orderCode)));

		this.repository.saveAll(reservations);
	}

	/**
	 * Compensating local transaction
	 * 
	 * @param orderCode: Saga id to is used to identify the order.
	 */
	public void cancelFlightScheduling(final String orderCode) {

		List<FlightReservation> flightReservations = this.repository.findByOrderCode(orderCode);

		if (isEmpty(flightReservations)) {
			return;
		}

		flightReservations.forEach(FlightReservation::cancelRerservation);
		this.repository.saveAll(flightReservations);
	}
}