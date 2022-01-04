pipeline {
    agent none 

    environment {
        DOCKER_HUB_USERNAME = credentials('DOCKER_HUB_USERNAME')
        DOCKER_HUB_PASSWORD = credentials('DOCKER_HUB_PASSWORD')
        CURRENT_COMMIT = getCommitHash()
    }

    stages {
        stage('Build') {
            agent any
            when {
                beforeAgent true
                branch 'main'
            }
            steps {
                sh 'echo $DOCKER_HUB_PASSWORD | docker login -u $DOCKER_HUB_USERNAME --password-stdin'
                sh 'docker build -t $DOCKER_HUB_USERNAME/msprdev:$CURRENT_COMMIT .'
                sh 'docker push $DOCKER_HUB_USERNAME/msprdev:$CURRENT_COMMIT'
                sh 'docker logout'
            }
        }
    }
}

def getCommitHash() {
    node {
        return sh(script: 'git rev-parse --short HEAD', returnStdout: true)
    }
}
