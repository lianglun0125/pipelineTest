pipeline {
    agent any
stages {
        stage('git clone') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/lianglun0125/pipelineTest.git'
            }  
            post {
                failure {
                    echo "[*] git clone failure"
                }
                success {
                    echo '[*] git clone successful'
                }
            }
        }
        stage('Build') {
            steps {
                bat 'javac main.java'
            }
            post {
                failure {
                    echo "[*] Build failure"
                }
                success {
                    echo '[*] Build successful'
                }
            }
        }
        stage('Run') {
            steps {
                
                bat 'java main'
            }
            post {
                failure {
                    echo "[*] Running failure"
                }
                success {
                    echo '[*] Running successful'
                }
            }
        }
    }
}
