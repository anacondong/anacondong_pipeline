helm template mychart . -f values.yaml > manifest.yaml

kubectl apply -f manifest.yaml

kubectl delete -f manifest.yaml

access to : http://localhost:30001/