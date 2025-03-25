FROM eclipse-temurin:21-jre-alpine
ARG JAR_FILE=build/libs/PermTravelServer-0.0.2-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]