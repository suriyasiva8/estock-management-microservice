FROM openjdk:15-jdk-alpine 
EXPOSE 8080
ADD target/estock-users.jar estock-users.jar 
ENTRYPOINT ["java","-jar","estock-users.jar","--spring.profiles.active=prod"] 