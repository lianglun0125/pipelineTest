def notifyLINE(status) {
    def token = "0os5iGWwcPiXlxOsglBIY3wNV4GyXsxizSNsh048qFe"
    def jobName = env.JOB_NAME +' '+env.BRANCH_NAME
    def buildNo = env.BUILD_NUMBER
      
    def url = 'https://notify-api.line.me/api/notify'
    def message = "${jobName} Build #${buildNo} ${status} \r\n"
    sh "curl ${url} -H 'Authorization: Bearer ${token}' -F 'message=${message}'"
}

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
                sh 'dotnet ef database update -p "Mockup.DAL/Mockup.DAL.csproj" -s "Mockup/Mockup.csproj"'
                sh 'dotnet test "Mockup.Test/Mockup.Test.csproj"'
            }
            post {
                failure {
                    echo "[*] Build failure"
                    notifyLINE("succeed")
                }
                success {
                    echo '[*] Build successful'
                    notifyLINE("failed")
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
        }
    }
}
