def call() {
    def commitId = sh(returnStdout: true, script: 'git rev-parse HEAD')
    return commitId
}