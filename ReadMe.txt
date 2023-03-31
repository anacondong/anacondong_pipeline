docker pull jenkins/jenkins
docker run -p 8080:8080 -p 50000:50000 jenkins/jenkins


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



