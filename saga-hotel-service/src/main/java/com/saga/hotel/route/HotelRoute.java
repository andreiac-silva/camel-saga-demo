package com.saga.hotel.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.SagaPropagation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saga.hotel.service.HotelReservationService;

@Component
public class HotelRoute extends RouteBuilder {

	@Autowired
	private HotelReservationService hotelReservationService;
	
	@Override
	public void configure() {
    	
        rest()
        	.post("/hotel/book")
        	.route()
        	.saga()
        	.propagation(SagaPropagation.MANDATORY)
	            .to("direct:bookHotel")
	            .compensation("direct:cancelHotelScheduling");

        from("direct:bookHotel")
        	.bean(this.hotelReservationService, 
        		"bookHotel(${header.customerId}, ${header.numberOfPeople}, ${header.Long-Running-Action}, ${header.hotelCode})")
        	.log("Hotel scheduling has done. Order code: ${header.Long-Running-Action}.");
    
	    from("direct:cancelHotelScheduling")
	    	.bean(this.hotelReservationService, "cancelHotelScheduling(${header.Long-Running-Action})")
	        	.log("Scheduling for hotel ${header.hotelCode} has been cancelled. Order code: ${header.Long-Running-Action}.");

    }
	
}
