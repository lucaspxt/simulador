FROM docker.prd.useredecloud/java:1.11.0
ARG JAR_FILE=target/simulador-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} simulador.jar
ENTRYPOINT ["java","-jar","simulador.jar"]
EXPOSE 8080
