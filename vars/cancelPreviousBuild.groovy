def call() {
  String jobName = env.JOB_NAME
  int currentBuildNumber = env.BUILD_NUMBER.toInteger()


  def job = Jenkins.instance.getItemByFullName(jobName)
  for (build in job.builds) {
    if (build.isBuilding() && currentBuildNumber > build.getNumber().toInteger()) {
      build.doStop();
      echo "Build ${build.toString()} was cancelled"
    }
  }
}