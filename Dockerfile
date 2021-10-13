FROM openjdk

WORKDIR /app

COPY target/password-0.0.1-SNAPSHOT.jar /app/password.jar

ENTRYPOINT ["java", "-jar", "password.jar"]