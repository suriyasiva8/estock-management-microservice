FROM openjdk:15-jdk-alpine 
EXPOSE 8080
ADD target/estock-management.jar estock-management.jar 
ENTRYPOINT ["java","-jar","estock-management.jar","--spring.profiles.active=prod"] 