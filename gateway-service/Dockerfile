FROM openjdk:8-jdk-alpine
MAINTAINER Maurizio Ferrero <ferrero.maurizio84@gmail.com>

ENV PORT 8080
RUN mkdir -p /usr/local/demo
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/local/disloman/gateway-service.jar
EXPOSE 8080
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/local/disloman/gateway-service.jar"]