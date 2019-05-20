FROM openjdk:11-jdk-slim
MAINTAINER Ernestas Kardzys <ernestas.kardzys@gmail.com>
VOLUME /tmp
ADD /build/libs/backend-service.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
