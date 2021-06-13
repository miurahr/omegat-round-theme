plugins {
    java
    checkstyle
    distribution
    maven
    id("org.omegat.gradle") version "1.5.3"
}

version = "0.0.1"

repositories {
    mavenLocal()
}

omegat {
    version = "5.6.0"
    pluginClass = "tokyo.northside.omegat.theme.RoundThemes"
}

dependencies {
    packIntoJar("com.formdev:flatlaf:1.2")
}

checkstyle {
    isIgnoreFailures = true
    toolVersion = "7.1"
}

distributions {
    main {
        contents {
            from(tasks["jar"], "README.md", "COPYING", "CHANGELOG.md")
        }
    }
}
