FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy project files (excluding the JAR)
COPY . . !tungty-service-0.0.1-SNAPSHOT.jar

# Copy the pre-built JAR file
COPY tungty-service-0.0.1-SNAPSHOT.jar .

EXPOSE 8087
ENTRYPOINT ["java", "-jar", "tungty-service.jar"]
