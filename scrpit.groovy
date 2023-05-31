def buildJar() {
    echo "building the application..."
    sh 'cd my-app'
    sh 'npm install'
    sh 'npm run build'
}

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t aliaymanmohammed/demo-app:node-1.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push aliaymanmohammed/demo-app:node-1.0'
    }
}

def deployApp() {
    echo 'deploying the application...'
}

return this
