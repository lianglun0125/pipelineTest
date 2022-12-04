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
                sh 'javac Calculator.java'
                sh 'javac -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar CalculatorTest.java'
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
        stage('Unit Test') {
            steps {
                sh 'java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar CalculatorTest'
            }
            post {
                failure {
                    echo "[*] Test failure"
                }
                success {
                    echo '[*] Test successful'
                }
            }
        }
        stage('CI finish') {
            steps {
                echo "[*] CI finish"
            }
        }
    }
}
