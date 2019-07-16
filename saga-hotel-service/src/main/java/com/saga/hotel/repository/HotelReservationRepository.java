package com.saga.hotel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saga.hotel.model.HotelReservation;

@Repository
public interface HotelReservationRepository extends CrudRepository<HotelReservation, Long> {

	HotelReservation findByOrderCode(String orderCode);
}