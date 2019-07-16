FROM openjdk:8-jre-alpine
WORKDIR /travel-pack
COPY ./target/saga-travel-pack-service.jar /travel-pack/app.jar
CMD ["/usr/bin/java","-jar","/travel-pack/app.jar"]
EXPOSE 4000
