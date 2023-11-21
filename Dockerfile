FROM openjdk:17-slim as build
COPY  target/demo-argela-0.0.1-SNAPSHOT.jar demo-argela-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "demo-argela-0.0.1-SNAPSHOT.jar"]