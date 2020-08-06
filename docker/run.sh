#!/bin/sh
# remove container
CONTAINER=docker-db-access
docker stop ${CONTAINER}
docker rm ${CONTAINER}

# clean & build jar file
./gradlew clean build test

# docker build
docker -build --build-arg JAR_FILE=build/docker-db-access-0.1.0.jar -t example/docker-db-access:0.1.0 --force-rm .

# docker run
docker run -d \
  -p 8087:8087 \
  -e DB_URL="jdbc:postgresql://host.docker.internal:5432/example-db"
  -e DB_USERNAME=dhayashi \
  -e DB_PASSWORD=zaq12wsx \
  --name docker-db-access \
  example/docker-db-access:0.1.0
