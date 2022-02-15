pipeline {
    agent none 

    environment {
        //DOCKER_HUB_USERNAME = credentials('DOCKER_HUB_USERNAME')
        //DOCKER_HUB_PASSWORD = credentials('DOCKER_HUB_PASSWORD')
        CURRENT_COMMIT = "1"
    }

    stages {
        stage('Build') {
            agent any
            when {
                beforeAgent true
                branch 'develop'
            }
            steps {
                sh 'echo Build'
            }
        }
    }
}
