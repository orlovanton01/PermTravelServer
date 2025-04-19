FROM eclipse-temurin:21-jre-alpine
#21-jre-ubi9-minimal
#FROM openjdk:21-jdk-slim

ARG JAR_FILE=build/libs/PermTravelServer-0.0.3-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]