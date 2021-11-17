#!/bin/bash

echo "Performing Maven Build"
./mvnw clean package -DskipTests=true

echo "Packaging the customer service"
cd customer-service
docker build -t customer-service .
cd ..

echo "Packaging the order service"
cd order-service
docker build -t order-service .
cd ..

echo "Packaging the gateway service"
cd gateway-service
docker build -t gateway-service .
cd ..

echo "Packaging the discovery service"
cd discovery-service
docker build -t discovery-service .
cd ..

echo "Done"
