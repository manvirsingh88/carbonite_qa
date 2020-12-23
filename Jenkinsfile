pipeline {
    agent {
    label 'master'}

    stages {
        stage('Build') {
            steps {
                echo 'Cleaning Workspace...'
                echo 'Branch Name: ${params.branch}'
                bat "mvn clean -X"
            }
        }   
         stage('Verify'){
        steps{
        
        echo 'Verify Work Space'
        bat 'mvn verify -X'
        
            }
        }          
        stage('Compile') {
            steps {
                echo 'Compile.....'
                bat "mvn compile -X"
            }
        }
        stage('Test') {
            steps {
                echo 'Test....'
                bat "mvn test -X"
            }
        }
        stage('Install'){
        
        steps{
            
            echo 'install'
            bat "mvn install -X"
        }

            }   
       
    }
}
