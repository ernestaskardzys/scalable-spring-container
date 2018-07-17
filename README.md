## Introduction
 
I have decided to create a project which could handle high load. The result is this project - Spring Boot application with Nginx as load balancer and ActiveMQ as message broker.

I have used the following technologies:
* [Spring Boot](http://spring.io/projects/spring-boot)
* [Docker](https://www.docker.com/)
* [Docker Compose](https://docs.docker.com/compose/)
* [Nginx](https://www.nginx.com/)
* [Gradle](https://gradle.org/)
* [ActiveMQ](http://activemq.apache.org/)
* [MongoDB](https://www.mongodb.com/)

## Architecture
This example shows how to handle high load by using message queues. Basic workflow is as follows:

* User sends POST request to port 80 with data
* Request is handled by Nginx. It works as load balancer and uses Least Connections technique for load balancing.
* Request is redirected to one of 4 frontend applications (project: gateway-service)
* Request is put into ActiveMQ's message queue.
* There are 4 backend applications (project: backend-service). They are waiting for messages to appear on message queue.
* Once new message appears on the queue "messages", one of 4 backend applications will pick it up and handle it - save to MongoDB database.

This project works well as a demonstration of load balancing and message queues. Although you'd probably use something like [Kubernetes](https://kubernetes.io/) for your production system, instead of Docker Compose.

## Running application

```bash
$ ./gradlew clean build
$ docker-compose build
$ docker-compose up --scale gateway-service=4 --scale backend-service=4
```

Then simply send a POST request to the backend:
```bash
$ curl --header "Content-Type: application/json" \
      --request POST \
      --data '{ "name": "John Doe" }' \
      http://localhost/data
```

You should see response in the console of Docker and data should be saved to the MongoDB.

## MongoDB

To see the database of MongoDB - please open http://localhost:8081/
