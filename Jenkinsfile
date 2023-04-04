pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Clean package') {
            steps {
                sh '/Users/anacondong/apache-maven-3.9.0/bin/mvn clean package'
            }
        }

        stage('test') {
            steps {
                sh 'echo mvn test'
            }
        }

        stage('Code Coverage') {
            steps {
                sh 'echo run SonaQube , IQ Server'
            }
        }

        stage('Mutation test') {
                    steps {
                        sh 'echo run Mutation test'
                    }
                }

        stage('security check') {
            steps {
                sh 'echo run Aquasec'
            }
        }

        stage('Build And Push Docker Image') {
            steps {
                sh 'docker build -t myapp .'
                withCredentials([usernamePassword(credentialsId: 'DockerHub', passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
                    sh "docker login -u $DOCKERHUB_USERNAME -p $DOCKERHUB_PASSWORD"
                }
                sh "docker tag myapp anacondong/myapp"
                sh "docker push anacondong/myapp"
            }
        }

        stage('Deploy') {
            steps {
                sh 'helm template release-myapp ./helmChart -f ./helmChart/values.yaml > ./helmChart/manifest.yaml'
                sh 'kubectl apply -f ./helmChart/manifest.yaml'
            }
        }
    }
}
