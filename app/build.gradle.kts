@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("stradivariustechnicaltest.android.application")
    id("stradivariustechnicaltest.android.application.compose")
    id("stradivariustechnicaltest.android.hilt")
}

android {
    namespace = "com.icdominguez.stradivariustechnicaltest"
    defaultConfig {
        applicationId = "com.icdominguez.stradivariustechnicaltest"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    with(libs) {
        implementation(core.ktx)
        implementation(lifecycle.runtime.ktx)
        implementation(activity.compose)
        implementation(ui)
        implementation(ui.graphics)
        implementation(ui.tooling.preview)
        implementation(androidx.core.splashscreen)
        implementation(material3)
        implementation(androidx.hilt.navigation.compose)
        implementation(design.material.extended)
        testImplementation(junit)
        androidTestImplementation(androidx.test.ext.junit)
        androidTestImplementation(espresso.core)
        debugImplementation(ui.tooling)
        debugImplementation(ui.test.manifest)
    }
    implementation(project(":core:designsystem"))
    implementation(project(":feature:home"))
    implementation(project(":feature:detail"))
}
