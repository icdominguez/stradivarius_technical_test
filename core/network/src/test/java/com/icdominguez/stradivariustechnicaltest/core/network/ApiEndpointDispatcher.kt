package com.icdominguez.stradivariustechnicaltest.core.network

import com.icdominguez.stradivariustechnicaltest.core.common.mvi.fakedata.FakeObjects
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class ApiEndpointDispatcher: Dispatcher() {
    override fun dispatch(request: RecordedRequest): MockResponse {
        print("The request path is \n \n ${request.path} \n\n why is it failing")

        //https://randomuser.me/api/?page=1&results=10&seed=abc

        return when(request.path) {
            "/api/?page=1&results=1&seed=abc" -> MockResponse()
                .setResponseCode(200)
                .setBody(FakeObjects.contactsPage1)

            "/api/?page=100000000&results=1&seed=abc" -> MockResponse()
                .setResponseCode(404)
                .setBody("{\"error\":\"There is nothing here.\"}")

            else -> {
                MockResponse()
                    .setResponseCode(404)
                    .setBody("{\"error\":\"There is nothing here.\"}")
            }
        }
    }
}