FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY target/hackathon-paciente-*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]