package com.icdominguez.stradivariustechnicaltest.core.network

import com.icdominguez.stradivariustechnicaltest.core.network.model.response.GetContactsResponse
import javax.inject.Inject

class StradivariusNetwork @Inject constructor(
    private val networkApi: StradivariusNetworkApi,
) : StradivariusNetworkDataSource {
    override suspend fun getContacts(page: Int, results: Int, seed: String): GetContactsResponse =
        networkApi.getContacts(page, results, seed)
}
