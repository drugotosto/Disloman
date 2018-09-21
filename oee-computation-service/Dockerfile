FROM openjdk:8-jdk-alpine
MAINTAINER Maurizio Ferrero <ferrero.maurizio84@gmail.com>

RUN mkdir -p /usr/local/demo
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/local/demo/consumer.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/local/demo/consumer.jar"]