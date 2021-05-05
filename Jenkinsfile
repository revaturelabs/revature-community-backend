pipeline { 
    agent any
    stages{
        stage('Checkout'){
            steps {
                git branch: 'doom', url: 'https://github.com/revaturelabs/revature-community-backend.git'
            }
        }

        stage('Build'){
            steps {
                sh 'chmod a+x mvnw'
                //We can change this to false when we want to actually have the tests run during build
                //Tests increase build time
                sh './mvnw clean package -DskipTests=true'
            }
            post{
                always{
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        
        stage('DockerBuild') {
            steps {
                sh 'docker build -t revaturelabs/revature-community-backend:latest .'
            }
        }
        
        stage('Deploy'){
            steps{    
                sh 'sudo docker run --env-file /home/ec2-user/env.lis -p 9095:9095 revaturelabs/revature-community-backend'
            }}
    }
}
