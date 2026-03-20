plugins {
    application
    kotlin("jvm") version "2.3.10"
    kotlin("plugin.spring") version "2.3.10"
    id("org.springframework.boot") version "4.0.3"
    id("io.spring.dependency-management") version "1.1.7"
    id("project-report")
}

group = "com.pretz"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-mail")
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation(kotlin("test-junit5"))
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:6.0.3")
}

kotlin {
    jvmToolchain(25)
}

tasks.test {
    useJUnitPlatform()
}