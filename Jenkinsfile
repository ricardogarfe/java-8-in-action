pipeline {
  agent any
  stages {
    stage('Compile') {
      steps {
        sh 'mvn compile'
      }
    }
    stage('Test') {
      steps {
        sh 'mvn test -Dmaven.test.failure.ignore=true'
      }
    }
    stage('Results') {
      steps {
        junit(allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml')
      }
    }
  }
}