FROM maven:3.8.3-openjdk-17

WORKDIR /financial-info

COPY . .

RUN mvn clean install -DskipTests

ENTRYPOINT ["java", "-jar", "target/financial-info-0.0.1-SNAPSHOT.jar"]