package com.icdominguez.stradivariustechnicaltest.core.network

import com.icdominguez.stradivariustechnicaltest.core.network.model.response.GetContactsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface StradivariusNetworkApi {

    @GET("api/")
    suspend fun getContacts(
        @Query("page") page: Int,
        @Query("results") results: Int,
        @Query("seed") seed: String,
    ): GetContactsResponse
}