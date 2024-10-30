FROM maven:3.9.3-eclipse-temurin-17 AS build

WORKDIR /app

COPY . .

RUN mvn clean package

FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]