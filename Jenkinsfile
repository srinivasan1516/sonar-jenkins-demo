pipeline {
  agent any

  tools {
    // If Jenkins has Maven configured as a tool, you can use: maven 'M3'
    // Otherwise we will just call "mvn" from system.
  }

  environment {
    // This must match the Jenkins SonarQube server name you configured
    SONARQUBE_SERVER = 'sonarqube'
  }

  stages {
    stage('Checkout') {
      steps {
        // Jenkins will checkout automatically if you connected a Git repo,
        // but keeping it explicit is fine.
        checkout scm
      }
    }

    stage('Build & Test') {
      steps {
        sh '''
          echo "Building project..."
          mvn -v
          mvn clean test
        '''
      }
    }

    stage('SonarQube Analysis') {
      steps {
        withSonarQubeEnv("${SONARQUBE_SERVER}") {
          sh '''
            echo "Running SonarQube scan..."
            mvn sonar:sonar \
              -Dsonar.projectKey=hello-sonar \
              -Dsonar.projectName=hello-sonar
          '''
        }
      }
    }
  }

  post {
    always {
      echo "Pipeline finished."
    }
  }
}