pipeline {
    agent any

    environment {
        // Optional: Define environment variables if needed
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/kirank1994/Appium.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'clean test -DTAG_NAME=$TAG_NAME' // or your test command
            }
        }
    }

    post {
        always {
            emailext(
                subject: "Build Report - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """<p>Hi Team,</p>
                         <p>Build #${env.BUILD_NUMBER} completed. Please find the attached TestNG HTML report.</p>
                         <p><a href="${env.BUILD_URL}">Click here to open the Jenkins Job</a></p>""",
                mimeType: 'text/html',
                to: 'kirankonduri018@gmail.com',
                attachmentsPattern: '**/test-output/emailable-report.html'
            )
        }
    }
}