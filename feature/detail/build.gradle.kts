plugins {
    id("stradivariustechnicaltest.android.feature")
    id("stradivariustechnicaltest.android.library.compose")
}

android {
    namespace = "com.icdominguez.stradivariustechnicaltest.feature.detail"
}

dependencies {
    implementation(project(":domain:contacts"))
    implementation(project(":feature:maps"))
}
