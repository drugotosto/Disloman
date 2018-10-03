FROM openjdk:8-jdk-alpine
MAINTAINER Maurizio Ferrero <ferrero.maurizio84@gmail.com>

RUN mkdir -p /usr/local/demo
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/local/disloman/oee-computation-service.jar
ENTRYPOINT ["/usr/bin/java", "-Djava.security.egd=file:/dev/urandom","-jar","/usr/local/disloman/oee-computation-service.jar"]