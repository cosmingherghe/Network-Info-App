FROM maven:3.9.4-eclipse-temurin-17 AS build

WORKDIR /app

COPY * .

RUN mvn clean install

FROM eclipse-temurin:17-jre

RUN apt-get update && apt-get upgrade -y

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
