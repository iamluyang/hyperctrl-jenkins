package com.hyperctrl.jenkins.constants

class Constants {

    // --------------------------------------------------
    // Notification
    // --------------------------------------------------

    /**
     * EMAIL
     */
    public static final String EMAIL_MESSAGE_HEADER = "Sending Email"

    /**
     * SLACK
     */
    public static final String SLACK_MESSAGE_HEADER = "Sending Slack Notification"

    // --------------------------------------------------
    // GITHUB
    // --------------------------------------------------

    /**
     * JENKINS_GITHUB_CREDENTIALS_ID
     */
    public static final String JENKINS_GITHUB_CREDENTIALS_ID = "github_credentials"

    /**
     * AWSCLI_CHECK_VERSION_COMMAND
     */
    public static final String AWSCLI_CHECK_VERSION_COMMAND = "aws --version"

    // --------------------------------------------------
    // SONARQUBE
    // --------------------------------------------------

    /**
     * SONARQUBE_CREDENTIALS_ID
     */
    public static final String SONARQUBE_CREDENTIALS_ID = "sonarqube-credentials"

    /**
     * this is the name given to the SonarQube instance configured under Jenkins Configuration
     */
    public static final String SONARQUBE_INSTALLATION_NAME = "MySonarQubeServer"
}