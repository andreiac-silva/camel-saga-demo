package com.saga.travel.pack.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.SagaPropagation;
import org.springframework.stereotype.Component;

@Component
public class TravelPackRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
    	
        rest()
        	.post("/travel-pack/")
	        .route()
	        .saga()
	        .setHeader(Exchange.HTTP_METHOD, constant("POST"))
	        .setHeader("orderId", header(Exchange.SAGA_LONG_RUNNING_ACTION))
		        .to("http4://flight-service:4001/api/flight/book?bridgeEndpoint=true")
		        .to("http4://hotel-service:4002/api/hotel/book/?bridgeEndpoint=true")
		        .to("http4://payment-service:4003/api/pay/?bridgeEndpoint=true")
	        	.propagation(SagaPropagation.REQUIRED)
	        .end();
    }
}
