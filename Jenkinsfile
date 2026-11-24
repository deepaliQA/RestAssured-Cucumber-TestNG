
pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out automation project'
                checkout scm
            }
        }

        stage('Java Check') {
            steps {
                bat 'java -version'
            }
        }

        stage('Maven Check') {
            steps {
                bat '"C:\\Tools\\apache-maven-3.10.2\\bin\\mvn.cmd" -version'
            }
        }

        stage('Execute API Automation') {
            steps {
                bat '"C:\\Tools\\apache-maven-3.10.2\\bin\\mvn.cmd" clean test'
            }
        }
    }

    post {
        always {
            archiveArtifacts(
                artifacts: 'target/cucumber-reports/**',
                allowEmptyArchive: true
            )
        }
    }
}
