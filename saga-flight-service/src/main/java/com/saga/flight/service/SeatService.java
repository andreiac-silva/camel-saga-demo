package com.saga.flight.service;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.saga.flight.exception.UnavailableNumberOfSeatsException;
import com.saga.flight.model.Seat;
import com.saga.flight.model.Seat.Status;
import com.saga.flight.repository.SeatRepository;

@Service
public class SeatService {

	private static final Logger logger = LoggerFactory.getLogger(SeatService.class);

	@Autowired
	private SeatRepository repository;

	public List<Seat> findAvailableSeatsByFlightCode(final Integer numberOfSeats, final String code) throws UnavailableNumberOfSeatsException {

		List<Seat> seats = this.repository.findByStatusAndFlightCode(Status.AVAILABLE, code, PageRequest.of(0, numberOfSeats));

		if (isEmpty(seats)) {
			logger.error("There are not {} seats available", numberOfSeats);
			throw new UnavailableNumberOfSeatsException();
		}

		return seats;
	}
	
	public void save(List<Seat> seats) {

		this.repository.saveAll(seats);
	}
}
