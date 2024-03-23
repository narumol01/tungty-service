FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy project files
COPY . .

# Build the JAR using Gradle
RUN gradle build

# Copy the JAR file (assuming Gradle's default location)
COPY /build/libs/tungty-service-0.0.1-SNAPSHOT.jar tungty-service.jar

EXPOSE 8087
ENTRYPOINT ["java", "-jar", "tungty-service.jar"]
