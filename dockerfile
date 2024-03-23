FROM gradle:7.5.1-jdk17 AS build
WORKDIR /app  # Optional working directory

# Assuming a Gradle wrapper is present
RUN ./gradlew clean build

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /app/build/libs/demo-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]
