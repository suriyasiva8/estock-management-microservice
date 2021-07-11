helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
helm repo update
# Helm
 helm install [RELEASE_NAME] prometheus-community/kube-prometheus-stack
 username:admin and password:prom-operator for grafana
 
 
 
For Kibana/Grafana took entire container logs
---------------------------------------------------
https://www.magalix.com/blog/monitoring-of-kubernetes-cluster-through-prometheus-and-grafana  -->use the same password and username mentioned here
https://github.com/prometheus-community/helm-charts/tree/main/charts/kube-prometheus-stack  -->refered to install the stack.