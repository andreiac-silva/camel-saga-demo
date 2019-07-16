package com.saga.payment.model.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saga.payment.exception.CustomerInsufficientMilesExceeded;
import com.saga.payment.exception.FlightNoRegisteredException;
import com.saga.payment.exception.HotelNotRegisteredException;
import com.saga.payment.exception.NumberOfGuestsNotAllowed;
import com.saga.payment.model.Order;
import com.saga.payment.model.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	@Autowired
	private OrderLineService orderLineService;

	@Autowired
	private CustomerMilesService customerMilesService;

	@Transactional
	public void save(final Long customerId, final Integer numberOfPeople, final String orderCode,
			final String flightCode, final String hotelCode) throws FlightNoRegisteredException,
			NumberOfGuestsNotAllowed, HotelNotRegisteredException, CustomerInsufficientMilesExceeded {

		Order order = new Order(customerId, orderCode);
		order.addOrderLine(this.orderLineService.createFlightOrderLine(flightCode, order, numberOfPeople));
		order.addOrderLine(this.orderLineService.createHotelOrderLine(hotelCode, order, numberOfPeople));

		this.customerMilesService.debitCustomerMiles(customerId, order.getTotal());
		this.repository.save(order);
	}

	public void cancel(final String orderCode) {
		this.repository.cancelOrder(orderCode);
	}
}
