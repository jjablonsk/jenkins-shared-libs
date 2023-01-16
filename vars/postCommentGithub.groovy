def call(def text_pr) {
    if (env.BRANCH_NAME.startsWith('PR-')) {
        def prNum = getPullRequestNumber()
        withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: '<id>', usernameVariable: 'USERNAME', passwordVariable: 'GITHUB_TOKEN']]) {
        sh "curl -s -H \"Authorization: token ${GITHUB_TOKEN}\" -X POST -d '{\"body\": \"${text_pr}\"}' \"https://api.github.com/repos/${repository_name}/issues/${pr_num}/comments\""
        }
    }
    return " Not supported - branch must be a Pull Request to post comment "
}