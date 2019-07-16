FROM openjdk:8-jre-alpine
WORKDIR /hotel
COPY ./target/saga-hotel-service.jar /hotel/app.jar
CMD ["/usr/bin/java","-jar","/hotel/app.jar"]
EXPOSE 4002