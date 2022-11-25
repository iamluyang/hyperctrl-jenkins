package com.hyperctrl.jenkins.ci.github

class Git implements Serializable {

    private final def script

    Git(def script) {
        this.script = script
    }

    def checkout(String repositoryUrl, String credentialsId) {
        this.script.git credentialsId: credentialsId, url: repositoryUrl
    }

    String commitHash() {
        return this.script.sh(script: getLatestGitCommitHashCommand(), returnStdout: true).trim()
    }

    private static String getLatestGitCommitHashCommand() {
        return "git rev-parse HEAD"
    }
}
