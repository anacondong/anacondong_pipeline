pipeline {
    agent {
        docker {
            image 'maven:3.8.3-openjdk-17'
            args '-v /var/run/docker.sock:/var/run/docker.sock'
        }
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Clean') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'docker version'
                sh 'echo run mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    def dockerImage = docker.build("myapp")
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'DockerHub', passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
                    sh "docker login -u $DOCKERHUB_USERNAME -p $DOCKERHUB_PASSWORD"
                }
                script {
                    def dockerImage = docker.build("myapp")
                    dockerImage.push()
                }
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
