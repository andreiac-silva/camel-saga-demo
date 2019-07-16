package com.saga.payment.model.service;

import java.math.BigInteger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saga.payment.exception.CustomerInsufficientMilesExceeded;
import com.saga.payment.model.CustomerMiles;
import com.saga.payment.model.repository.CustomerMilesRepository;

@Service
public class CustomerMilesService {

	@Autowired
	private CustomerMilesRepository repository;

	@Transactional
	public void debitCustomerMiles(Long customerId, BigInteger orderValue) throws CustomerInsufficientMilesExceeded {

		CustomerMiles customerMiles = this.repository.findFirstByCustomerId(customerId);

		if (customerMiles.getAmountOfMiles().compareTo(orderValue) < 0) {
			throw new CustomerInsufficientMilesExceeded();
		}
		
		customerMiles.subtractMiles(orderValue);
		
		this.repository.save(customerMiles);
	}
}
