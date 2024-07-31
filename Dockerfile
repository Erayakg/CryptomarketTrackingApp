FROM maven:3.8.5-openjdk AS build

WORKDIR /base

COPY pom.xml .
COPY src ./src

RUN mvn clean install

FROM openjdk

WORKDIR /base

COPY  /target/base-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
