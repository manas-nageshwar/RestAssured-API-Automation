pipeline {
    agent any 

    tools {
        // This must match the name you give Maven in Jenkins Global Tool Configuration
        maven 'Maven3' 
        jdk 'Java17'
    }

    stages {
        stage('Checkout') {
            steps {
                // This pulls your code from Git
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project...'
                sh 'mvn clean compile'
            }
        }

        stage('API Tests') {
            steps {
                echo 'Running RestAssured tests against Math.js API...'
                // Running only the tests
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            echo 'Archiving Test Reports...'
            // This grabs your Surefire reports so you can see them in Jenkins
            junit '**/target/surefire-reports/*.xml'
        }
    }
}