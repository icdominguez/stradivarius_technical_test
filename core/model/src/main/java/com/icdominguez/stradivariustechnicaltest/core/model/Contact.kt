package com.icdominguez.stradivariustechnicaltest.core.model

data class Contact(
    val name: String,
    val email: String,
    val gender: String,
    val registered: String,
    val picture: String,
    val phone: String,
    val location: ContactLocation
)

data class ContactLocation(
    val latitude: Double,
    val longitude: Double
)