package com.icdominguez.stradivariustechnicaltest.core.network.model.response

data class GetUsersInfo(
    val seed: String,
    val results: Int,
    val page: Int,
    val version: String
)
