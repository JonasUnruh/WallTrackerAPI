FROM openjdk:11
MAINTAINER tornado.com
COPY target/spring-boot-docker.jar spring-boot-docker.jar
ENTRYPOINT ["java","-jar","/spring-boot-docker.jar"]