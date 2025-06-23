FROM maven:3.8.5-openjdk-11 AS build
COPY pom.xml /build/
COPY src /build/src
WORKDIR /build
RUN mvn -q package -DskipTests

FROM openjdk:11-jre-slim
COPY --from=build /build/target/demo-0.0.1-SNAPSHOT.war /app.war
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.war"]
