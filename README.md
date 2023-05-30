# Restful-api-with-Mongodb
implement Restful api(CRUD) with Mongodb

demo: 
1. build docker image: ubuntu-20.04
   docker build -f Dockerfile-ubuntu-20.04 -t ubuntu-20.04 .

2. build docker image: ubuntu-20.04-build
   docker build -f Dockerfile-ubuntu-20.04-build -t ubuntu-20.04-build .

3. build code
   docker-compose build

4. run code
   docker-compose up -d

5. use postman to call api(myapi.postman_collection.json)
