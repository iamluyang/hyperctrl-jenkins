import com.hyperctrl.jenkins.ci.github.Git

def call(Map args=[:], Closure body={}) {
    node {
        stage('Setup parameters') {
            steps {
                script {
                    properties([
                            parameters([
                                    choice(choices: [
                                            'git@github.com:iamluyang/hyperctrl-okra.git',
                                            'git@github.com:iamluyang/hyperctrl-jenkins.git'],
                                            description: 'Choosing a URL for your remote repository',
                                            name: 'repositoryUrl'),

                                    choice(choices: [
                                            '1d4290fd-3403-4135-aea4-b4846aa50d4f',
                                            'ec16884-9502-457a-a8a5-9e8bf6371693'],
                                            description: 'Choosing a credentialsId for your remote repository',
                                            name: 'credentialsId'),

                                    choice(choices: ['master', 'dev', 'test', 'demo', 'prep', 'prod'],
                                            description: 'Choosing a branch for your remote repository',
                                            name: 'branch'),

                                    booleanParam(defaultValue: false, description: 'Run Unit Test', name: 'unitTest'),

                                    booleanParam(defaultValue: false, description: 'Run Integration Test', name: 'integrationTest'),

                                    booleanParam(defaultValue: false, description: 'Run Health Check', name: 'healthCheck'),

                                    booleanParam(defaultValue: false, description: 'Run SonarQube Check', name: 'sonarQubeCheck'),

                                    booleanParam(defaultValue: false, description: 'Package Artifact', name: 'isPackageArtifact'),

                                    choice(choices: [
                                            'NONE',
                                            'Nexus',
                                            'Harbor'],
                                            description: 'Publish Artifact to remote repository',
                                            name: 'publishArtifact'),

                                    booleanParam(defaultValue: false, description: 'Build Docker Image', name: 'isBuildDockerImage'),

                                    choice(choices: [
                                            'NONE',
                                            'Nexus',
                                            'Harbor'],
                                            description: 'Publish Docker Image to remote repository',
                                            name: 'buildDockerImage'),

                                    booleanParam(defaultValue: true, description: 'Deploy Application', name: 'IsDeployContainer'),

                                    choice(choices: [
                                            'NONE',
                                            'Tomcat',
                                            'Websphere',
                                            "AWS-EKS",
                                            "Azure-AKS",
                                            "Google-GCP",],
                                            description: 'Deploy Application to remote container',
                                            name: 'deployContainer')
                            ])
                    ])
                }
            }
        }

        stage("Checkout") {
            new Git(this).checkout("${args.repositoryUrl}", "${args.credentialsId}", )
        }

        stage("Compile") {
            sh "./mvnw clean compile"
        }

        stage("Unit Test") {
            sh "./mvnw test.groovy"
        }

        stage("Integration Test") {
            sh "./mvnw verify"
        }

        stage("Package Artifact Jar") {
            sh "./mvnw package -DskipTests=true"
        }
        body()
    }
}
