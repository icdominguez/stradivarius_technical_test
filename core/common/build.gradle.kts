@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("stradivariustechnicaltest.android.library")
}

android {
    namespace = "com.icdominguez.stradivariustechnicaltest.core.common"
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.appcompat)

    implementation(libs.retrofit.converter.gson)
}