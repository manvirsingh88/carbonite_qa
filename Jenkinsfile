pipeline {
    agent {
    label 'master'}

    stages {
        stage('Build') {
            steps {
            echo "BUILD_NUMBER=${env.BUILD_NUMBER}"
            echo "BRANCH_NAME=${env.BRANCH_NAME}"
                echo 'Cleaning Workspace...'
                echo "Branch Name: ${params.branch}"
                bat "mvn clean -U -X"
            }
        }   
         stage('Verify'){
        steps{
        
        echo 'Verify Work Space'
        bat "mvn verify -Dmaven.test.failure.ignore=true -X"
        
            }
        }          
        stage('Compile') {
            steps {
                echo 'Compile.....'
                bat "mvn compile -U -X"
            }
        }
        stage('Test') {
            steps {
                echo 'Test....'
                bat "mvn test -Dmaven.test.failure.ignore=true"
            }
        }
        stage('Install'){
        
        steps{
            
            echo 'install'
            bat "mvn install -Dmaven.test.failure.ignore=true -X"
        }

            }   
       
    }
    post{
        always{
            echo "Build Completed. Current Build Result=${currentBuild.currentResult}"
                                          }
                                          
                                          changed {
                                              sendNotification(buildChanged: true)
                                          }

        }
        
        def sendNotification(buildChanged){
            if (currentBuild.currentResult== 'SUCCESS') {       
            script{
            emailext(to: 'manvir.singh.parmar88@gmail.com',subject: "$JOB_NAME - Build # ${currentBuild.currentResult}!",body:"The build is back to normal.", mimietype:'text/html')
 
                                                                                               
                }

                }
                
                else  if (currentBuild.currentResult== 'FAILURE') {       
            script{
            emailext(to: 'manvir.singh.parmar88@gmail.com',subject: "$JOB_NAME - Build # ${currentBuild.currentResult}!",body:"Something went wrong", mimietype:'text/html')
 
                                                                                               
                }

                }
            }

        }


    


