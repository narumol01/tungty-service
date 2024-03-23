#FROM openjdk:17-jdk-slim
#EXPOSE 8087
#ADD /build/libs/tungty-service-0.0.1-SNAPSHOT.jar tungty-service.jar
#ENTRYPOINT ["java", "-jar", "tungty-service.jar"]


FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy project files
COPY . .

# Build the JAR using Maven (assuming Maven is installed)
RUN mvn clean package

# Copy the JAR file
COPY /build/libs/tungty-service-0.0.1-SNAPSHOT.jar tungty-service.jar

EXPOSE 8087
ENTRYPOINT ["java", "-jar", "tungty-service.jar"]
