pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Clean package') {
            agent {
                label 'local'
            }
            steps {
                sh 'mvn clean package'
            }
        }

        stage('test') {
            steps {
                sh 'echo mvn test'
            }
        }

        stage('Build And Push Docker Image') {
            agent {
                label 'local'
            }
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
            agent {
                label 'local'
            }
            steps {
                sh 'helm template release-myapp ./helmChart -f ./helmChart/values.yaml > ./helmChart/manifest.yaml'
                sh 'kubectl apply -f ./helmChart/manifest.yaml'
            }
        }
    }
}
