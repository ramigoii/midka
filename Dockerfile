FROM eclipse-temurin:21-jdk
MAINTAINER Ramina
COPY backend.jar endterm.jar
ENTRYPOINT ["java", "-jar", "endterm.jar"]
