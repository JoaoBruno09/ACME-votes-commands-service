pipeline {
    agent any
    stages {
        stage('Checkout'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'bitbucket', url: 'https://Tiagorpl@bitbucket.org/joaobruno1220256/acme_votes_commands.git']]])
            }
        }
        stage('Start Container') {
            steps {
                bat 'docker compose up -d'
            }
        }
    }
}
