rootProject.name = "Bookish ForNight"

include(":app")
include(":domain")
include(":data")
include(":core")
include(":core-ui")
include(":test-utils")
includeProject(":mvi-base", "mvi/mvi-base")
includeProject(":mvi-testing", "mvi/mvi-testing")

fun includeProject(name: String, filePath: String) {
  include(name)
  project(name).projectDir = File(filePath)
}
