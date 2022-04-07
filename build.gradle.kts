plugins {
    java
    checkstyle
    distribution
    maven
    id("org.omegat.gradle") version "1.5.7"
    id("com.palantir.git-version") version "0.15.0" apply false
}

// we handle cases without .git directory
val dotgit = project.file(".git")
if (dotgit.exists()) {
    // calculate version string from git tag, hash and commit distance
    apply(plugin = "com.palantir.git-version")
    val versionDetails: groovy.lang.Closure<com.palantir.gradle.gitversion.VersionDetails> by extra
    val details = versionDetails()
    val baseVersion = details.lastTag.substring(1)
    if (details.isCleanTag) {  // release version
        version = baseVersion
    } else {  // snapshot version
        version = baseVersion + "-" + details.commitDistance + "-" + details.gitHash + "-SNAPSHOT"
    }
} else {
    println("Read version property from gradle.properties.")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
    withSourcesJar()
    withJavadocJar()
}

omegat {
    version = "5.6.0"
    pluginClass = "tokyo.northside.omegat.theme.RoundThemes"
}

repositories {
    mavenCentral()
}

dependencies {
    packIntoJar("com.formdev:flatlaf:2.1")
}

checkstyle {
    isIgnoreFailures = true
    toolVersion = "7.1"
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-Xlint:deprecation")
    options.compilerArgs.add("-Xlint:unchecked")
}

distributions {
    main {
        contents {
            from(tasks["jar"], "README.md", "COPYING", "CHANGELOG.md")
        }
    }
}
