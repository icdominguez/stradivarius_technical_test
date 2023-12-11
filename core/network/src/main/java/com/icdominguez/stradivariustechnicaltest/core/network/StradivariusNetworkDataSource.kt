package com.icdominguez.stradivariustechnicaltest.core.network

import com.icdominguez.stradivariustechnicaltest.core.network.model.response.GetContactsResponse


interface StradivariusNetworkDataSource {

    suspend fun getContacts(page: Int, results: Int = 10, seed: String = "abc"): GetContactsResponse
}