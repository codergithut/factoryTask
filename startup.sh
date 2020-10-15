#!/bin/bash

docker rmi $(docker images | grep "none" | awk '{print $3}')

git pull

mvn clean

mvn package

mvn dockerfile:build

docker stop task

docker rm task

docker run -d -it -p 8080:8080 --name task tianjian3209/factory_task:develop