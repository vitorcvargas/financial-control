#!/bin/bash

cd ../

mvn clean package

cd local

docker-compose up --build

