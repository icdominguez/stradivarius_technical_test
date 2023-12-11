package com.icdominguez.stradivariustechnicaltest.core.network.model.response

data class GetContactsResponse(
    val info: GetUsersInfo,
    val results: List<GetUserResult>,
)
