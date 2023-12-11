package com.icdominguez.stradivariustechnicaltest.core.network.model.response

data class Location(
    val street: Street,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
    val coordinates: Coordinates,
    val timezone: Timezone,
)

data class Coordinates(
    val latitude: String,
    val longitude: String,
)

data class Street(
    val number: Long,
    val name: String,
)

data class Timezone(
    val offset: String,
    val description: String,
)
