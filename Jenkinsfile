pipeline {
  agent any
  tools { 
    maven 'Maven 3' 
  }
  stages {
    stage ('Initialize') {
      steps {
        sh '''
          echo "PATH = ${PATH}"
          echo "M2_HOME = ${M2_HOME}"
        ''' 
      }
    }
    stage('Compile') {
      steps {
        sh 'mvn compile'
      }
    }
    stage('Test') {
      steps {
        sh 'mvn test -Dmaven.test.failure.ignore=true'
      }
      post {
        success {
            junit '**/target/surefire-reports/*.xml' 
          }
      }
    }
    stage('SonarQube analysis') {
      steps {
        withSonarQubeEnv('Sonarqube') {
          sh 'mvn sonar:sonar'
        }
      }
    }
  }
}
