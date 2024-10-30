pipeline {
    agent any
    stages {
        stage('Update Image - Network-Info-App') {
            steps {
                sh 'ls -a'
                sh 'docker build -t netinfo:test -f NetInfoApp.dockerfile .'
            }
        }
    }
}
