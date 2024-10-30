pipeline {
    agent any
    stages {
        stage('Update Image - Network-Info-App') {
            steps {
                sh 'docker build -t netinfo:test -f JDK17.dockerfile .'
            }
        }
    }
}
