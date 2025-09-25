# Use Maven to build the JAR
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Use an official OpenJDK image as base
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the jar file into the container
COPY target/product-service-0.0.1-SNAPSHOT.jar app.jar

# Expose the port (same as in application.properties/yml)
EXPOSE 8083

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
