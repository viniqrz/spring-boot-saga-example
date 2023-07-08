# Spring Boot Transaction (Saga) Implementation with Apache Kafka 🦭

### The app contains an example of Kafka configuration and a simple dummy e-commerce architecture for demonstration purposes.

### Feel free to use it as a template for your own projects.

### ⚠️ Important:
- The app is not production ready. It is just a simple example of how to use Kafka with Spring Boot.
- There are other styles of Saga implementation. This is just one of them.
- Kafka configuration in Spring Boot can be a bit confusing, not all properties set in application.properties files will be applied to the client (e.g: auto-commiting). The safest way is to create a Configuration Class like the one inside payment service module.

### ✅ How to run:
- Clone the repository.
- Make sure you have Maven, Docker and Docker Compose installed.
- Build the project with Maven. Use the following command inside the root folder:
```sh
 mvn clean package spring-boot:repackage
```
- Now You can use the following command to start all containers:
```sh
docker-compose up -d
```
- Control center is a great way to visualize your Kafka cluster. You can access it at http://localhost:9021 once all containers are up and running.

### 📸 Control center in your browser should look like this:

![Control Center](https://docs.confluent.io/platform/current/_images/c3-clusters-main-page.png)

### Technologies used:
- Spring Boot
- Apache Kafka
- Spring for Apache Kafka

## Versions:
- Docker: 20.10.5
- Compose: 1.25.0
- Apache Maven: 3.6.3
- Java: 11

Wanna improve this project? Feel free to open a PR! 🚀

If you have any questions, feel free to contact me at: [LinkedIn](https://www.linkedin.com/in/viniqrz/)