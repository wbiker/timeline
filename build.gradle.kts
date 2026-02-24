plugins {
	java
	id("org.springframework.boot") version "4.0.2"
	id("io.spring.dependency-management") version "1.1.7"
//	id("org.liquibase.gradle") version "3.1.0"
}

group = "com.bastelbude"
version = "0.0.1-SNAPSHOT"
description = "Time records"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(25)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()

	dependencies {
//		classpath("org.liquibase:liquibase-core:4.31.1")
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-data-rest")
	implementation("org.springframework.boot:spring-boot-starter-liquibase")
	implementation("org.springframework.boot:spring-boot-starter-webmvc")
	implementation("org.postgresql:postgresql:42.7.7")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-data-jpa-test")
	testImplementation("org.springframework.boot:spring-boot-starter-data-rest-test")
	testImplementation("org.springframework.boot:spring-boot-starter-liquibase-test")
	testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
	testImplementation("org.springframework.boot:spring-boot-testcontainers")
	testImplementation("org.testcontainers:testcontainers-junit-jupiter")
	testImplementation("org.testcontainers:testcontainers-postgresql")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

//	liquibaseRuntime 'org.liquibase:liquibase-core:4.31.1'
//	liquibaseRuntime 'org.liquibase:liquibase-groovy-dsl:4.0.1'
//	liquibaseRuntime 'info.picocli:picocli:4.6.1'
//	liquibaseRuntime 'mysql:mysql-connector-java:5.1.34'
}

tasks.withType<Test> {
	useJUnitPlatform()
}
