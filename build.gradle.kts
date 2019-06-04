import org.gradle.api.tasks.testing.logging.TestLogEvent.*

plugins {
  idea
  java
  id("com.github.ben-manes.versions") version Globals.Gradle.Plugin.versionsVersion
}

tasks {
  withType(Wrapper::class.java) {
    gradleVersion = Globals.Gradle.wrapperVersion
    distributionType = Wrapper.DistributionType.BIN
  }
}

defaultTasks("clean", "test")

allprojects {
  apply(plugin = "java")

  group = Globals.Project.groupId
  version = Globals.Project.version

  java {
    sourceCompatibility = Globals.javaVersion
    targetCompatibility = Globals.javaVersion
  }

  repositories {
    mavenCentral()
  }

  tasks {
    named("clean") {
      doLast {
        delete(
            project.buildDir,
            "${project.projectDir}/out"
        )
      }
    }
  }
}

subprojects {
  apply(plugin = "scala")

  sourceSets {
    main {
      withConvention(ScalaSourceSet::class) {
        scala {
          setSrcDirs(listOf("src/main/scala"))
        }
      }
    }
    test {
      withConvention(ScalaSourceSet::class) {
        scala {
          setSrcDirs(listOf("src/test/scala"))
        }
      }
    }
  }

  dependencies {
    implementation("org.scala-lang:scala-library:${Globals.scalaVersion}")
    testImplementation(platform("org.junit:junit-bom:${Globals.junitJupiterVersion}"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("junit:junit:${Globals.junitVersion}")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine")
  }

  tasks {
    withType<Test> {
      useJUnitPlatform()
      testLogging {
        showExceptions = true
        showStandardStreams = true
        events(PASSED, SKIPPED, FAILED)
      }
    }
  }
}
