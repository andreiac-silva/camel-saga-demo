package com.saga.payment.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.SagaPropagation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saga.payment.model.service.OrderService;

@Component
public class PaymentRoute extends RouteBuilder {

	@Autowired
	private OrderService orderService;

	@Override
	public void configure() throws Exception {
		
		rest()
			.post("/pay")
			.route()
			.saga()
			.propagation(SagaPropagation.MANDATORY)
			    .compensation("direct:cancelOrder")
				.to("direct:createOrder");

		from("direct:createOrder").bean(this.orderService,
				"save(${header.customerId}, ${header.numberOfPeople}, ${header.Long-Running-Action}, ${header.flightCode}, ${header.hotelCode})")
				.log("Order succesfully created for customer ${header.customerId}.");

		from("direct:cancelHotelScheduling")
				.bean(this.orderService, "cancel(${header.Long-Running-Action})")
				.log("Order ${header.Long-Running-Action} has been cancelled.");

	}

}
