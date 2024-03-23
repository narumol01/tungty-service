FROM gradle:7.5.1-jdk17 AS build
WORKDIR /app
COPY . .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]
