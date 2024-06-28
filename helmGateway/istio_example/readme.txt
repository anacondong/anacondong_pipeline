kubectl create namespace dev
kubectl label namespace dev istio-injection=enabled

kubectl apply -n dev -f api-deployment.yaml
kubectl apply -n dev -f api-service.yaml
kubectl apply -n dev -f api-gateway.yaml
kubectl apply -n dev -f api-virtualservice.yaml


kubectl get pods -n dev
kubectl get svc -n dev
kubectl get gateway -n dev
kubectl get virtualservice -n dev
