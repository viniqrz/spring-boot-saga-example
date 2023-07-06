# Spring Boot Transactional Saga Implementation with Apache Kafka

### The app contains an example of Kafka configuration and a simple dummy e-commerce architecture for demonstration purposes.

### Feel free to use it as a template for your own projects.

### Important:
- The app is not production ready. It is just a simple example of how to use Kafka with Spring Boot.
- There are other styles of Saga implementation. This is just one of them.
- Kafka configuration in Spring Boot can be a bit confusing, not all properties set in application.properties files will be applied to the client. The safest way is to create Configuration Class like the one inside payment API module.

### How to run:
- Start Zookeeper, Kafka and Control Center all together with docker-compose.yml file inside docker folder.
- You can use the following command to start all containers:
```sh
docker-compose up -d
```
- Control center is a great way to visualize your Kafka cluster. You can access it at http://localhost:9021 once all containers are up and running.

### Technologies used:
- Spring Boot
- Apache Kafka
- Spring for Apache Kafka

## Versions:
- Spring Boot: 2.4.2
- Apache Kafka: 2.7.0
- Spring for Apache Kafka: 2.6.4
- Java: 11
