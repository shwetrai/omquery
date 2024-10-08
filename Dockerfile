 FROM openjdk:17
 MAINTAINER ecosystem
 RUN mkdir /app
 WORKDIR /app
 COPY /target/omquery-0.0.1-SNAPSHOT.jar  omqueryapi.jar
 COPY /target/classes/application.properties application.properties
 CMD java -jar omqueryapi.jar
