pipeline {
    agent {
        docker {
            image 'maven:3.8.3-openjdk-17'
            args '-v /var/run/docker.sock:/var/run/docker.sock'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    def dockerImage = docker.build("my-app:${env.BUILD_NUMBER}")
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
                    sh "docker login -u $DOCKERHUB_USERNAME -p $DOCKERHUB_PASSWORD"
                }
                script {
                    def dockerImage = docker.build("my-app:${env.BUILD_NUMBER}")
                    dockerImage.push()
                }
            }
        }
        stage('Deploy') {
            steps {
                withCredentials([sshUserPrivateKey(credentialsId: 'ssh-credentials', keyFileVariable: 'SSH_KEY_FILE', passphraseVariable: '', usernameVariable: 'SSH_USERNAME')]) {
                    sshagent(['SSH_KEY_FILE']) {
                        sh "ssh $SSH_USERNAME@my-server 'docker-compose up -d'"
                    }
                }
            }
        }
    }
}
