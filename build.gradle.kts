plugins {
    kotlin("jvm") version "1.9.0"
}

group = "be.jobulcke"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation(platform("org.junit:junit-bom:5.10.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core:3.24.2")}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}