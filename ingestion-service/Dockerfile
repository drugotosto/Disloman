FROM openjdk:8-jdk-alpine
MAINTAINER Maurizio Ferrero <ferrero.maurizio84@gmail.com>

ENV PORT 8080
RUN mkdir -p /usr/local/disloman
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/local/disloman/ingestion-service.jar
EXPOSE 8080
ENTRYPOINT ["/usr/bin/java", "-Djava.security.egd=file:/dev/urandom", "-jar", "/usr/local/disloman/ingestion-service.jar"]