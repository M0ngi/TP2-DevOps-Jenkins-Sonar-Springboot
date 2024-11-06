pipeline {
    agent any
    tools {
        maven 'Maven 3.9.9'
    }
    
    environment {
        DOCKERHUB = credentials('dockerhub')
        IMAGE_NAME = 'm0ngi/tp2-devops'
        CODE_REPOSITORY = 'https://github.com/M0ngi/TP2-DevOps-Jenkins-Sonar-Springboot.git'
    }
    
    stages {
        stage('Clone repository') {
            steps {
                checkout scmGit(branches: [[name: 'dev']], extensions: [], userRemoteConfigs: [[url: "${CODE_REPOSITORY}"]])

            }
        }
        
        stage('Build & Test project') {
            steps {
                sh 'mvn -f ./spring-boot/pom.xml clean package'
            }
        }
        
        stage('Static Code Analysis: Sonarqube') {
            steps {
                sh 'mvn -f ./spring-boot/pom.xml clean package'
            }
        }
        
        stage('Build docker image') {
            steps {
                sh "docker build -t ${IMAGE_NAME}:${env.BUILD_NUMBER} ./spring-boot"
            }
        }
        
        stage('Push image to Dockerhub') {
            steps {
                sh 'docker login -u $DOCKERHUB_USR -p $DOCKERHUB_PSW'
                sh "docker push ${IMAGE_NAME}:${env.BUILD_NUMBER}"
            }
        }
        
        stage('Clean up') {
            steps {
                sh "docker rmi ${IMAGE_NAME}:${env.BUILD_NUMBER}"
                sh 'docker logout' 
            }
        }
    }
}