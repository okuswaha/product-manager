pipeline {
    agent any

    stages {
        stage('Project Build') {
            steps {
                echo 'Building..'
                sh 'mvn clean install'
            }
        }
        stage('Docker Build') {
            steps {
                echo 'Building Docker image..'
                sh 'docker build -t "product-manager:1.0" .'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                sh 'docker run -d -p 9081:9081 product-manager:1.0'
            }
        }
    }
}