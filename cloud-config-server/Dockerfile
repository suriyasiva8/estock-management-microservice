FROM openjdk:15-jdk-alpine 
EXPOSE 8888
ADD target/estock-cloud-config-server.jar estock-cloud-config-server.jar 
ENTRYPOINT ["java","-jar","estock-cloud-config-server.jar","--spring.profiles.active=prod"] 