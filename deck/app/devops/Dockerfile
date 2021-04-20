FROM 833104194858.dkr.ecr.us-east-1.amazonaws.com/qa-bootcamp_base-image:latest

USER spring:spring

ARG JAR_FILE=./app/build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
