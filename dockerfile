FROM openjdk:17-jdk-slim
EXPOSE 8087
ADD /build/libs/tungty-service-0.0.1-SNAPSHOT.jar tungty-service.jar
ENTRYPOINT ["java", "-jar", "tungty-service.jar"]