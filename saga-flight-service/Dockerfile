FROM openjdk:8-jre-alpine
WORKDIR /flight
COPY ./target/saga-flight-service.jar /flight/app.jar
CMD ["/usr/bin/java","-jar","/flight/app.jar"]
EXPOSE 4001