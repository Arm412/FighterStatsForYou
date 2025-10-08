# Multi-stage Dockerfile for Spring Boot app
FROM maven:3.9.9-eclipse-temurin-21 as build
WORKDIR /workspace
COPY pom.xml mvnw* ./
COPY src ./src
RUN mvn -DskipTests package
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /workspace/target/*.jar app.jar
# install netcat so we can probe the postgres port at container start
RUN apt-get update && apt-get install -y --no-install-recommends netcat-openbsd && rm -rf /var/lib/apt/lists/*

# copy wait script (added in a separate file) and make it executable
COPY wait-for-postgres.sh /app/wait-for-postgres.sh
RUN chmod +x /app/wait-for-postgres.sh
EXPOSE 8080
ENTRYPOINT ["sh","/app/wait-for-postgres.sh"]
