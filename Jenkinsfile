pipeline {
    agent any

    environment {
        REPORT = 'target/surefire-reports/emailable-report.html'
    }

    parameters {
        string(name: 'TAG_NAME', defaultValue: '@smoke', description: 'Cucumber tag to execute')
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/kirank1994/Appium.git', branch: 'main'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean test -DTAG_NAME=${TAG_NAME}'
            }
        }

        stage('Publish Report') {
            steps {
                archiveArtifacts artifacts: "${REPORT}", onlyIfSuccessful: true
            }
        }
    }

    post {
        success {
            emailext(
                subject: "✅ Jenkins Build Success - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """<h2>Build Successful</h2>
                         <p>Job: ${env.JOB_NAME}</p>
                         <p>Build: #${env.BUILD_NUMBER}</p>
                         <p>Tag Executed: ${params.TAG_NAME}</p>
                         <p>See attached test report.</p>""",
                to: 'kirankonduri018@gmail.com',
                attachLog: true,
                attachmentsPattern: "${REPORT}",
                mimeType: 'text/html'
            )
        }

        failure {
            emailext(
                subject: "❌ Jenkins Build Failed - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """<h2>Build Failed</h2>
                         <p>Job: ${env.JOB_NAME}</p>
                         <p>Build: #${env.BUILD_NUMBER}</p>
                         <p>Check Jenkins for more details.</p>""",
                to: 'kirankonduri018@gmail.com',
                attachLog: true,
                mimeType: 'text/html'
            )
        }
    }
}