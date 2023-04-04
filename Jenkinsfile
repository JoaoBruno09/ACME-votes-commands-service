pipeline {
    agent any
    stages {
        stage('Start Container') {
            steps {
                bat 'docker compose up -d'
            }
        }
    }
}
