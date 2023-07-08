FROM openjdk:11

# Working directory for the application
WORKDIR /home/app

## Copying the jar file to the container
COPY target/*.jar app.jar

# Exposing the port
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
