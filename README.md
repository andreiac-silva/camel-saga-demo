# camel-saga-demo
Demo prepared for presentation: "A Saga da consistência de dados entre microservices".
The projects are using spring boot + h2 + camel lra integration to simulate a Saga flow.

## How to run this project

This project can be executed by docker with simple steps:

1. Access **each service** folder and generate its images. You can do that executing the following file in terminal:
    ```
    sh generate-image.sh
    ```
2. Back to main folder and run ```docker-compose up -d```.

## Requests examples

***Success (first time execution, because we have to consider the data in h2)***


***Fail***
