pipeline {
    agent any
    environment {
       DB_URL = "${env.DB_URL}"
       DB_USER = "${env.DB_USER}"
       DB_PW = "${env.DB_PW}"
       RABBIT_PORT = "${env.RABBIT_PORT}"
    }
    stages {
        stage('Start Container') {
            steps {
                bat 'docker compose up -d'
            }
        }
    }
}
