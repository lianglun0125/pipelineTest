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
                bat 'javac Calculator.java'
                bat 'javac -cp .;junit-4.13.2.jar;hamcrest-core-1.3.jar CalculatorTest.java'
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
                bat 'java -cp .;junit-4.13.2.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore CalculatorTest'
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
            post {
                success {
                    bat 'curl -H "Authorization: Bearer 0os5iGWwcPiXlxOsglBIY3wNV4GyXsxizSNsh048qFe" -d "message=Build Succeed" https://notify-api.line.me/api/notify'
                }
                failure {
                bat 'curl -H "Authorization: Bearer 0os5iGWwcPiXlxOsglBIY3wNV4GyXsxizSNsh048qFe" -d "message=Build Failed" https://notify-api.line.me/api/notify'
                }
            }
        }
    }
}
