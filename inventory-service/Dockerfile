# Use an official OpenJDK image as base
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the jar file into the container
COPY target/inventory-service-0.0.1-SNAPSHOT.jar app.jar

# Expose the port (same as in application.properties/yml)
EXPOSE 8082

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
