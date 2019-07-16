package com.saga.flight.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saga.flight.model.Seat;
import com.saga.flight.model.Seat.Status;

@Repository
public interface SeatRepository extends CrudRepository<Seat, Long> {

	List<Seat> findByStatusAndFlightCode(Status status, String code, Pageable pageable);
}
