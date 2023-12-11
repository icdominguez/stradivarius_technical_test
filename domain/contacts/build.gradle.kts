plugins {
    id("stradivariustechnicaltest.android.library")
    id("stradivariustechnicaltest.android.hilt")
}

android {
    namespace = "com.icdominguez.stradivariustechnicaltest.domain.users"
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(project(":data:contacts"))

    implementation(project(":core:model"))
}