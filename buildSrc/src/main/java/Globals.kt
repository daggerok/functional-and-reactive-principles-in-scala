import org.gradle.api.JavaVersion

object Globals {

  object Project {
    const val version = "1.0-SNAPSHOT"
    const val artifactId = "functional-and-reactive-principles-in-scala"
    const val groupId = "com.github.daggerok"
  }

  val javaVersion = JavaVersion.VERSION_1_8
  //const val scalaMinorVersion = "3"
  const val scalaBaselineVersion = "2.12"
  const val scalaMinorVersion = "6"
  const val scalaVersion = "$scalaBaselineVersion.$scalaMinorVersion"

  const val junitVersion = "4.12"
  const val junitJupiterVersion = "5.5.0-M1"

  object Gradle {
    const val wrapperVersion = "5.5-rc-1"

    object Plugin {
      const val versionsVersion = "0.21.0"
    }
  }
}
