package com.saga.flight.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saga.flight.model.FlightReservation;

@Repository
public interface FlightReservationRepository extends CrudRepository<FlightReservation, Long> {

	List<FlightReservation> findByOrderCode(String orderCode);
}
