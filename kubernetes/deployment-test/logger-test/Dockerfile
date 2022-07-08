FROM openjdk:11
MAINTAINER Elias Meireles
ENV PORT 80
COPY target/logger.jar /service/
WORKDIR /service
EXPOSE $PORT
ENTRYPOINT ["java", "-jar", "logger.jar"]
