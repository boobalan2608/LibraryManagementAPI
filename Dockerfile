# Use Java 17 as base image
FROM eclipse-temurin:17-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory
COPY target/librarymanagement-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8081
EXPOSE 8081

# Run the application
CMD ["java", "-jar", "app.jar"]