# Stage 1: Build the application (The "Builder")
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy the pom.xml and source code
COPY pom.xml .
COPY src ./src

# Build the JAR file inside the container
RUN mvn clean package -DskipTests

# Stage 2: Run the application (The "Runtime")
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the JAR from the "build" stage to the final image
COPY --from=build /app/target/*.jar app.jar

# Expose port (Render uses 10000, but we handle it via env var)
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]