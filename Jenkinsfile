pipeline {
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
<<<<<<< HEAD
            // Execute your java file
            bat "java -jar Generator.jar"
=======
                // Execute your java file
                bat "java -jar Generator.jar"
>>>>>>> fb0c1ad6436a90a92c010c47bec1c4645fa9e8a9
            }
        }
    }
}
