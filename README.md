# Jenkins Shared Library

This is my personal Jenkins Shared Library.

This repository contains a library of Jenkins Global Variables & Helper Variables that I can use in my project's `Jenkinsfile`

# Usage

## Import Library

As per the instructions on the [Jenkins Documentation], to include this library; in your `Jenkinsfile`:

```groovy
@Library('jenkins-shared-library@1.0.0') _
```
note that the name is the `id` of the Shared Library configured under Jenkins Configuration and the version after the `@` sign 
can be `master` which points to the master branch of this library or simply omitted which would pick up the 
default version configured under Jenkins Configuration (if you have it configured there).

## Using Global Variables

To use one of the global variables or helper variables defined in this library you just simply call it like the following examples.

```groovy
@Library('jenkins-shared-library@1.0.0') _
buildJavaApp(repo: "name of repo")
```

```groovy
@Library('jenkins-shared-library@1.0.0') _
buildJavaAppDockerFull(repo: "name of repo", microserviceName: "example-app")
```

## Configuration

A lot of the configuration for external systems (Github, SonarQube etc) are set in the `Constants.groovy` constants class. 
You can edit this to match according to your settings.

## Global Vars Documentation

Each of the global variables (helper functions) has its own documentation (corresponding *.txt file). You can access these documentation on the __Global Variable Reference__ link on the navigation sidebar of pipeline jobs that imported this shared library. 

Note that as per Jenkins documentation this is only visible after one successful run of the pipeline job for the documentation to be generated.

The documentation is in (.txt) file format and contains HTML.

# Author

Summer Lu

# Release Notes

__v0.0.1__
+ basic Global Variables (steps) to build:
    + a Java App
    + a full pipeline of building a Java App (from checkout to deployment)
