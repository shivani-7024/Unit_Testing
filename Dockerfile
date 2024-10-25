FROM maven:3.8.3-openjdk-17 AS Build
COPY . .
RUN mvm clean package -DskipTests


FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/shivani-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]