# Use a base image for Java 17
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the application files to the container
COPY target/myapp.jar .

# Expose the port that the application will run on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "myapp.jar"]
