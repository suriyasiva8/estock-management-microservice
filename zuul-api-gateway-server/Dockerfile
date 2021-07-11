FROM openjdk:15-jdk-alpine 
EXPOSE 8011
ADD target/estock-zuul-api-gateway-server.jar estock-zuul-api-gateway-server.jar 
ENTRYPOINT ["java","-jar","estock-zuul-api-gateway-server.jar","--spring.profiles.active=prod"] 