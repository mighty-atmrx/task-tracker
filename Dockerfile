FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/task-tracker.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]