FROM eclipse-temurin:17-jre

RUN apt-get update && apt-get upgrade -y

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
