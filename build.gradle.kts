import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	// Spring Boot
	id("org.springframework.boot") version "2.3.2.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	// kotlin
	id("org.jetbrains.kotlin.jvm") version "1.3.72"
	id("org.jetbrains.kotlin.plugin.spring") version "1.3.72"
	id("org.jetbrains.kotlin.plugin.jpa") version "1.3.72"
	// Docker Gradle Plugin
	id("com.palantir.docker") version "0.25.0"
	id("com.palantir.docker-run") version "0.25.0"
}

group = "demo.example.dockerdbaccess"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	// Spring Boot
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	// kotlin
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	// postgresql
	runtimeOnly("org.postgresql:postgresql")
	// Spring Boot Test
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
	// DbSetup
	testImplementation("com.ninja-squad:DbSetup:2.1.0")
	// assert-db
	testImplementation("org.assertj:assertj-db:1.3.0")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

docker {
	//name "example/${bootJar}"
}
