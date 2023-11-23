FROM openjdk:17
MAINTAINER martinromeroxyz@gmail.com
ARG JAR_FILE=target/vass-code-challenge-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
VOLUME /tmp
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app.jar"]
