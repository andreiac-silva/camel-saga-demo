package com.saga.payment.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saga.payment.model.CustomerMiles;

@Repository
public interface CustomerMilesRepository extends CrudRepository<CustomerMiles, Long> {

	CustomerMiles findFirstByCustomerId(Long customerId);
}
