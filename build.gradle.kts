plugins {
    kotlin("jvm") version "1.9.0"
}

group = "be.jobulcke"
version = "1.0-SNAPSHOT"

val assertJVersion = "3.24.2"
val coroutinesVersion = "1.8.0-RC"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    testImplementation(kotlin("test"))
    testImplementation(platform("org.junit:junit-bom:5.10.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core:$assertJVersion")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}