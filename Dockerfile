FROM eclipse-temurin:17
RUN mkdir /opt/app
COPY ./target/*.jar /opt/app/dimdimcloudmasters.jar
EXPOSE 8080
CMD ["java", "-jar", "/opt/app/dimdimcloudmasters.jar"]