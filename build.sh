#!/bin/bash
# build
cd /Restful-api-with-Mongodb
mvn clean install "-Dmaven.test.skip=true"
