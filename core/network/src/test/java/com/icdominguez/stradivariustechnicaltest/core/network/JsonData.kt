package com.icdominguez.stradivariustechnicaltest.core.network

import com.icdominguez.stradivariustechnicaltest.core.network.model.response.Coordinates
import com.icdominguez.stradivariustechnicaltest.core.network.model.response.Dob
import com.icdominguez.stradivariustechnicaltest.core.network.model.response.GetContactsResponse
import com.icdominguez.stradivariustechnicaltest.core.network.model.response.GetUserResult
import com.icdominguez.stradivariustechnicaltest.core.network.model.response.GetUsersInfo
import com.icdominguez.stradivariustechnicaltest.core.network.model.response.ID
import com.icdominguez.stradivariustechnicaltest.core.network.model.response.Location
import com.icdominguez.stradivariustechnicaltest.core.network.model.response.Login
import com.icdominguez.stradivariustechnicaltest.core.network.model.response.Name
import com.icdominguez.stradivariustechnicaltest.core.network.model.response.Picture
import com.icdominguez.stradivariustechnicaltest.core.network.model.response.Street
import com.icdominguez.stradivariustechnicaltest.core.network.model.response.Timezone

object JsonData {
    val getContactsResponse = /*GetContactsResponse(
        info = GetUsersInfo(
            seed = "abc",
            results = 1,
            page = 1,
            version = "1.4"
        ),
        results = listOf(*/
            GetUserResult(
                gender = "female",
                name = Name(
                    title = "Miss",
                    first = "Laura",
                    last = "Woods"
                ),
                location = Location(
                    street = Street(
                        number = 2479L,
                        name = "Henry Street"
                    ),
                    city = "Blessington",
                    state = "Wexford",
                    country = "Ireland",
                    postcode = "78276",
                    coordinates = Coordinates(
                        latitude = "2.0565",
                        longitude = "95.2422",
                    ),
                    timezone = Timezone(
                        offset = "+1:00",
                        description = "Brussels, Copenhagen, Madrid, Paris"
                    )
                ),
                email = "laura.woods@example.com",
                login = Login(
                    uuid = "9f07341f-c7e6-45b7-bab0-af6de5a4582d",
                    username = "angryostrich988",
                    password = "racers",
                    salt = "B5ywSDUM",
                    md5 = "2eefb6307df2a5fb1f91c6b968dc905b",
                    sha1 = "33cbf1e97a31e14c87fb18c481d1f6d958c76cbd",
                    sha256 = "83e0c89668c8b6131df0c70fc4bb9abb8831e0ff97a0a29cdfa3949dd5afd491"
                ),
                dob = Dob(
                    date = "1967-07-23T09:18:33.666Z",
                    age = 56
                ),
                registered = Dob(
                    date = "2018-10-18T04:05:51.990Z",
                    age = 5
                ),
                phone = "031-623-5189",
                cell = "081-807-8083",
                id = ID(
                    name = "PPS",
                    value = "1101776T"
                ),
                picture = Picture(
                    large = "https://randomuser.me/api/portraits/women/88.jpg",
                    medium = "https://randomuser.me/api/portraits/med/women/88.jpg",
                    thumbnail = "https://randomuser.me/api/portraits/thumb/women/88.jpg"
                ),
                nat = "IE"
            )
        //)
    //)
}