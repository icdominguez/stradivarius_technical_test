plugins {
    id("stradivariustechnicaltest.android.library")
    id("stradivariustechnicaltest.android.hilt")
}

android {
    namespace = "com.icdominguez.stradivariustechnicaltest.core.preferences"
}

dependencies {
    implementation(libs.security.crypto)
}