pipeline {
    //test
    agent none 

    environment {      
        //DOCKER_HUB_USERNAME = credentials('DOCKER_HUB_USERNAME')
        //DOCKER_HUB_PASSWORD = credentials('DOCKER_HUB_PASSWORD')
        CURRENT_COMMIT = "1"
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            dir ("./Generator/"){
                // Execute your java file
                bat "java -jar Generator.jar"
            }
        }
    }
}
