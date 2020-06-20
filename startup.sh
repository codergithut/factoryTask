#!/bin/bash

git pull

mvn clean

mvn package

mvn dockerfile:build

docker stop facroty_task

docker rm factory_task

docker run -d -it -p 8080:8080 --name task tianjian3209/factory_task:develop