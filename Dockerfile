
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app


COPY pom.xml .
COPY src ./src



COPY target/api1-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]