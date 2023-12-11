plugins {
    id("stradivariustechnicaltest.android.feature")
    id("stradivariustechnicaltest.android.library.compose")
}

android {
    namespace = "com.icdominguez.stradivariustechnicaltest.feature.home"
}

dependencies {

    with(libs) {
        implementation(paging.compose)
    }

    implementation(project(":core:network"))
    implementation(project(":core:designsystem"))
    implementation(project(":domain:contacts"))
    implementation(project(":core:common"))
}