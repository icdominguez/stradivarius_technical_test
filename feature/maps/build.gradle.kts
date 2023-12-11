plugins {
    id("stradivariustechnicaltest.android.feature")
    id("stradivariustechnicaltest.android.library.compose")
}

android {
    namespace = "com.icdominguez.stradivariustechnicaltest.feature.maps"
}

dependencies {
    with(libs) {
        implementation(libs.maps.compose)
    }
}