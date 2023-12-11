plugins {
    id("stradivariustechnicaltest.android.library")
    id("stradivariustechnicaltest.android.hilt")
}

android {
    namespace = "com.icdominguez.stradivariustechnicaltest.data.users"
}

dependencies {

    implementation(libs.paging.compose)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.kotlinx.testCoroutines)

    implementation(project(":core:model"))
    implementation(project(":core:network"))
    implementation(project(":core:common"))
    implementation(project(":core:preferences"))
}
