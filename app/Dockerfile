FROM openjdk:11
VOLUME /tmp
#ARG JAR_FILE
ADD target/*.jar app.jar
ENTRYPOINT exec java -jar /app.jar