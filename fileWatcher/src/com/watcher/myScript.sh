#!/bin/bash
cd /Users/migo/Developer/environments/dev-env-1/backend
docker compose down
docker rm backend-1
docker image rm backend
mvn package
docker compose up -d


