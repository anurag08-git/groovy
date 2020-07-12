job('job1-deploy-web-server') {
    description('This job is for deploying the web-server')
    steps {
        shell('sh /mycode/code.sh')
    }
}
job('job2-test_code') {
    description('This job is for test the code and sent notification to developer')
    triggers {
        scm('@daily')
        upstream {
            upstreamProjects('job1-deploy-web-server')
            threshold('SUCCESS')
        }
    }
    steps {
        shell('sh /mycode/test_code.sh')
    }
}
buildPipelineView('Task 6') {
    filterBuildQueue()
    filterExecutors()
    title('Project for deploy web-server')
    displayedBuilds(5)
    selectedJob('job1-deploy-web-server')
    alwaysAllowManualTrigger()
    showPipelineParameters()
    refreshFrequency(60)
}
