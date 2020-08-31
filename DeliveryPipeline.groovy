pipeline {
    environment {
        registry = "johnbyrnejames/nodeapp_prod_ready"
        registryCredentials = 'DockerHub'
        dockerImage = ''
    }
    agent any
    stages {
        stage('Cloning our Git') {
            steps {
                git 'https://github.com/johnbyrnejames/node_app.git'
            }
        }
        stage('Building our image') {
            steps {
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
        stage('Deploy our image') {
            steps {
                script {
                    docker.withRegistry( '', registryCredentials ) {
                        dockerImage.push()
                    }
                }
            }
        }
        stage('Cleaning up') {
            steps {
                sh "docker rmi $registry:$BUILD_NUMBER"
            }
        }        
    }
}