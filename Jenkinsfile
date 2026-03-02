pipeline {
  agent any

  environment {
    // Must match: Manage Jenkins → System → SonarQube servers → Name
    SONARQUBE_SERVER = 'sonarqube'
  }

  stages {
    stage('Checkout') {
      steps {
        // Works when job is "Pipeline script from SCM"
        checkout scm
      }
    }

    stage('Build & Test') {
      steps {
        sh '''
          set -e
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
            set -e
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
