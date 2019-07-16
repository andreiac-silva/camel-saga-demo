FROM openjdk:8-jre-alpine
WORKDIR /payment
COPY ./target/saga-payment-service.jar /payment/app.jar
CMD ["/usr/bin/java","-jar","/payment/app.jar"]
EXPOSE 4003