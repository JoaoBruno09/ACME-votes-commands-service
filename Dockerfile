FROM maven:3.8.4-openjdk-17-slim AS builder
WORKDIR /app
COPY . .
RUN mvn clean package

FROM maven:3.8.4-openjdk-17-slim
WORKDIR /app
COPY --from=builder /app/target/votes-service-commands.jar votes-service-commands.jar
ENTRYPOINT ["java", "-jar", "votes-service-commands.jar"]