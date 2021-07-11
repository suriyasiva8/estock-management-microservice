Reference: https://dzone.com/articles/ultimate-guide-to-installing-kafka-docker-on-kuber

1st run zookeeper and kafka service

then run the command-->  kubectl describe svc kafka-service

from the output take the ip address of the LoadBalancerIngress and 
change the Broker.yaml env KAFKA_ADVERTISED_HOST_NAME,KAFKA_ADVERTISED_LISTENERS