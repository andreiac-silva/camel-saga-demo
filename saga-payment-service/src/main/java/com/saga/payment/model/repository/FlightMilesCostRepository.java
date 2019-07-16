package com.saga.payment.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saga.payment.model.FlightMilesCost;

@Repository
public interface FlightMilesCostRepository extends CrudRepository<FlightMilesCost, Long> {

	FlightMilesCost findFirstByCode(String code);
}
