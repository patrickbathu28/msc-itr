FROM adoptopenjdk/openjdk11
VOLUME /tmp
COPY target/msc-itr-0.0.1-SNAPSHOT.jar app.jar
CMD java -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=docker -jar /app.jar
EXPOSE 8085