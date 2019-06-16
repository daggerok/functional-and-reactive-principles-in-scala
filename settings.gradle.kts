rootProject.name = Globals.Project.artifactId

pluginManagement {
  repositories {
    gradlePluginPortal()
  }
}

include(
    ":functional-programming-principles-in-scala:week1",
    ":intro",
    ":template"
)
