# Multi-stage Dockerfile for Birthday Notifications Service
# Stage 1: Build the application
FROM gradle:9.2.0-jdk25 AS build

WORKDIR /app

# Copy Gradle wrapper and build files
COPY gradlew .
COPY gradle gradle/
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY gradle.properties .

# Download dependencies (cached layer)
RUN gradle dependencies --no-daemon || true

# Copy source code
COPY src src/

# Build the application
RUN gradle bootJar --no-daemon

# Stage 2: Create runtime image
FROM eclipse-temurin:25-jre-alpine

WORKDIR /app

# Create non-root user for security
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copy JAR from build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose application port
EXPOSE ${CONTAINER_PORT}

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
