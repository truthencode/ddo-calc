plugins {
    id("org.sonarqube")
}

sonar {
    properties {
        property("sonar.projectKey", "myProjectKey")
        property("sonar.host.url", "myHostUrl")
    }
}