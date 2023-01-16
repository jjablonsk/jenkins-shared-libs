def call() {
    if (env.BRANCH_NAME.startsWith('PR-')) {
        def prNum = env.BRANCH_NAME.replace('PR-', '').replace('-branch', '').replace('-merge', '').replace('-head', '')
        return prNum
    }
    else{
        return "This is not a Pull Request"
    }
}