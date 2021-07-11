FROM openjdk:15-jdk-alpine 
EXPOSE 8761
ADD target/estock-eureka-naming-server.jar estock-eureka-naming-server.jar 
ENTRYPOINT ["java","-jar","estock-eureka-naming-server.jar","--spring.profiles.active=prod"] 