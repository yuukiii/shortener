FROM openjdk:11
WORKDIR /app
VOLUME /tmp

#ARG JAR_FILE
ADD /app/target/*.jar app.jar
ENTRYPOINT exec java $JAVA_OPTS -Dspring.profiles.active=$APP_ACTIVE_PROFILE -Dserver.name=$HOSTNAME -jar /app.jar