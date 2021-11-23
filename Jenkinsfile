pipeline {
  
  agent any
  
  tools {
    maven 'Maven 3.8.3'
    jdk 'JDK11'
  }
  
  stages {
    
    stage("build") {
      steps {
        echo 'This is the building phase'
         sh 'mvn -Dmaven.test.failure.ignore=true install' 
      }
      post {
        success {
          junit 'target/surefire-reports/**/*.xml' 
        }          
      }
    }
    
    stage("test") {
      steps {
        echo 'This is the test phase'
        echo 'The test phase has been done rigth!'
      }
    }
    
    stage("deploy") {
      steps {
        echo 'This is the deploy phase'
      }
    }
  }
}
    
