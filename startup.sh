#!/bin/bash

git pull

mvn clean

mvn package

mvn dockerfile:build

docker stop facrotyTask

docker rm factoryTask

docker run -d -it -p 8080:8080 --name task tianjian3209/factoryTask:develop