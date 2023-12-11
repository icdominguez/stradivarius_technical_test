pluginManagement {
    includeBuild("build-logic")
    repositories {
        mavenCentral()
        gradlePluginPortal()
        google()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        google()
    }
}

rootProject.name = "Stradivariustechnicaltest"
include(":app")
include(":core:network")
include(":core:common")
include(":feature:home")
include(":feature:detail")
include(":data:contacts")
include(":domain:contacts")
include(":core:model")
include(":core:designsystem")
include(":core:preferences")
include(":feature:maps")
