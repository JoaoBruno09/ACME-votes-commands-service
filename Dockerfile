FROM openjdk:17
EXPOSE 8080
ADD target/votes-service-commands.jar votes-service-commands.jar
ENTRYPOINT [ "java", "-jar", "/votes-service-commands.jar"]