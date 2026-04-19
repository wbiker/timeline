plugins {
  `java-gradle-plugin`
	id("org.springframework.boot") version "4.0.2"
	id("io.spring.dependency-management") version "1.1.7"
  id("org.liquibase.gradle") version "3.1.0"
}

buildscript {
  dependencies {
    classpath("org.liquibase:liquibase-core:4.33.0")
  }
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
	create("liquibase")
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-data-rest")
	implementation("org.springframework.boot:spring-boot-starter-liquibase")
	implementation("org.springframework.boot:spring-boot-starter-webmvc")
	implementation("org.postgresql:postgresql:42.7.7")
  val mapstructVersion = "1.6.3"
  implementation("org.mapstruct:mapstruct:$mapstructVersion")
  annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")
	testAnnotationProcessor("org.mapstruct:mapstruct-processor:${mapstructVersion}")

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

  implementation("org.liquibase:liquibase-core:4.33.0")
  "liquibaseRuntime"("org.liquibase:liquibase-core:4.33.0")
  "liquibaseRuntime"("org.liquibase.ext:liquibase-hibernate6:4.33.0")

  "liquibase"("org.liquibase:liquibase-core:4.31.1")
	"liquibase"("org.postgresql:postgresql:42.7.7")
	"liquibaseRuntime"("info.picocli:picocli:4.7.6")
	"liquibase"("org.yaml:snakeyaml:2.0")
}

// Liquibase configuration
val liquibaseUrl = "jdbc:postgresql://localhost:6666/timeline"
val liquibaseUsername = "timeline"
val liquibasePassword = "timeline"
val liquibaseChangelogFile = file("src/main/resources/db/changelog/db.changelog-master.yaml").absolutePath

// Custom Liquibase tasks using JavaExec
tasks.register<JavaExec>("liquibaseUpdate") {
	group = "liquibase"
	description = "Apply pending changelog changes to the database"
	classpath = configurations["liquibase"]
	mainClass.set("liquibase.integration.commandline.LiquibaseCommandLine")
	args = listOf(
		"--changelogFile=$liquibaseChangelogFile",
		"--url=$liquibaseUrl",
		"--username=$liquibaseUsername",
		"--password=$liquibasePassword",
		"--driver=org.postgresql.Driver",
		"update"
	)
}

tasks.register<JavaExec>("liquibaseUpdateSQL") {
	group = "liquibase"
	description = "Preview SQL that would be executed for update"
	classpath = configurations["liquibase"]
	mainClass.set("liquibase.integration.commandline.LiquibaseCommandLine")
	args = listOf(
		"--changeLogFile=$liquibaseChangelogFile",
		"--url=$liquibaseUrl",
		"--username=$liquibaseUsername",
		"--password=$liquibasePassword",
		"--driver=org.postgresql.Driver",
		"updateSQL"
	)
}

tasks.register<JavaExec>("liquibaseGenerateChangelog") {
	group = "liquibase"
	description = "Generate a new changelog from the current database schema"
	classpath = configurations["liquibase"]
	mainClass.set("liquibase.integration.commandline.LiquibaseCommandLine")
	args = listOf(
		"--changeLogFile=${file("src/main/resources/db/changelog/003_generated.yaml").absolutePath}",
		"--url=$liquibaseUrl",
		"--username=$liquibaseUsername",
		"--password=$liquibasePassword",
		"--driver=org.postgresql.Driver",
		"generateChangeLog"
	)
}

tasks.register<JavaExec>("liquibaseDiff") {
	group = "liquibase"
	description = "Compare database to changelog"
	classpath = configurations["liquibase"]
	mainClass.set("liquibase.integration.commandline.LiquibaseCommandLine")
	args = listOf(
		"--changeLogFile=$liquibaseChangelogFile",
		"--url=$liquibaseUrl",
		"--username=$liquibaseUsername",
		"--password=$liquibasePassword",
		"--driver=org.postgresql.Driver",
		"diff"
	)
}

tasks.register<JavaExec>("liquibaseStatus") {
	group = "liquibase"
	description = "Show pending changesets"
	classpath = configurations["liquibase"]
	mainClass.set("liquibase.integration.commandline.LiquibaseCommandLine")
	args = listOf(
		"--changeLogFile=$liquibaseChangelogFile",
		"--url=$liquibaseUrl",
		"--username=$liquibaseUsername",
		"--password=$liquibasePassword",
		"--driver=org.postgresql.Driver",
		"status",
		"--verbose"
	)
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<JavaExec>().configureEach {
	classpath = sourceSets.main.get().runtimeClasspath
	// Exclude Gradle's SLF4J binding
	classpath = classpath.minus(
		configurations.runtimeClasspath.get()
			.filter { it.name.startsWith("gradle") }
	)
}

