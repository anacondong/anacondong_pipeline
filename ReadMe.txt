** Run app


docker-compose up
docker build -t myapp .
docker login -u xxx -p xxx  << do login to my dockerHub
docker tag myapp anacondong/myapp
docker push anacondong/myapp

## Deploy to k8s
cd helmChart
helm lint  << checking helm
helm template release-myapp ./helmChart -f ./helmChart/values.yaml > ./helmChart/manifest.yaml

helm template release-myapp ./helmChart -f ./helmChart/values.yaml  << Generate yaml at console
helm install myapp ./helmChart --values ./helmChart/values.yaml   <<< Install and run k8s
helm delete myapp
## Apply k8s
kubectl get services
kubectl apply -f ./helmChart/manifest.yaml
kubectl port-forward service/myappservice 8080:8080

kubectl delete -f ./helmChart/manifest.yaml

## TODO kubectl
helmChart
helm create helmChart
deployment
service
configMap
Secret

** Jenkins pipeline state (with Docker) But I prefer install locally
docker pull jenkins/jenkins
docker run -p 8085:8080 -p 50000:50000 jenkins/jenkins -v $(which docker):/usr/bin/docker

/state
init
clean
test
test coverage
Verify security , SonaQube, IQ Server, Veracode, Aquasec
package
push lib
docker img, build, tag, push
Deployment  >> EKS, Kubectl, HelmChart



** Install jenkins locally
https://www.jenkins.io/download/lts/macos/
brew install jenkins-lts
brew services start jenkins-lts
brew services stop jenkins-lts

issue: https://stackoverflow.com/questions/40043004/docker-command-not-found-mac-mini-only-happens-in-jenkins-shell-step-but-wo/58688536#58688536


#### sideCar project with istio gateway
install istio >> curl -L https://istio.io/downloadIstio | sh -

Istio deploy >> helm install istio-base istio/base -n istio-system --set defaultRevision=default
Enable Automatic Sidecar Injection >> kubectl label namespace <namespace> istio-injection=enabled
