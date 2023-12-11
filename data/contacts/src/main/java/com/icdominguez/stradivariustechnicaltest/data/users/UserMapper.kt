package com.icdominguez.stradivariustechnicaltest.data.users

import com.icdominguez.stradivariustechnicaltest.core.model.Contact
import com.icdominguez.stradivariustechnicaltest.core.model.ContactLocation
import com.icdominguez.stradivariustechnicaltest.core.network.model.response.GetUserResult

fun GetUserResult.toContact(): Contact {
    return Contact(
        name = "${this.name.title} ${this.name.first} ${this.name.last}",
        email = email,
        gender = gender,
        registered = this.registered.date,
        picture = this.picture.thumbnail,
        phone = phone,
        location = ContactLocation(
            this.location.coordinates.latitude.toDouble(),
            this.location.coordinates.longitude.toDouble()
        ),
    )
}