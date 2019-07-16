package com.saga.flight.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.SagaPropagation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saga.flight.service.FlightReservationService;

@Component
public class FlightRoute extends RouteBuilder {

	@Autowired
	private FlightReservationService flightReservationService;
	
    @Override
    public void configure() throws Exception {

        rest()
        	.post("/flight/book")
        	.route()
            .saga()
            .propagation(SagaPropagation.MANDATORY)
	            .to("direct:bookFlight")
	            .compensation("direct:cancelFlightScheduling");

        from("direct:bookFlight")
            .bean(this.flightReservationService, 
            		"bookFlight(${header.customerId}, ${header.numberOfPeople}, ${header.Long-Running-Action}, ${header.flightCode})")
            .log("Flight ${header.flightCode} has scheduled for ${header.numberOfPeople} passengers. Order code: ${header.Long-Running-Action}.");
        
        from("direct:cancelFlightScheduling")
        	.bean(this.flightReservationService, "cancelFlightScheduling(${header.Long-Running-Action})")
            .log("Scheduling for flight ${header.flightCode} has been cancelled. Order code: ${header.Long-Running-Action}.");
    }
}
