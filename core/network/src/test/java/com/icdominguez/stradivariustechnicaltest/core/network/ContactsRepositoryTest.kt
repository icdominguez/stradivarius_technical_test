package com.icdominguez.stradivariustechnicaltest.core.network

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.CoreMatchers.hasItem
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ContactsRepositoryTest : BaseTest() {
    private lateinit var stradivariusNetworkDataSource: StradivariusNetworkDataSource

    @Before
    override fun setup() {
        super.setup()
        stradivariusNetworkDataSource = StradivariusNetwork(stradivariusNetworkApi)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `GET CONTACTS - given a valid page returns valid contacts`() = runTest {
        val page = 1
        val results = 1
        val actualContacts = stradivariusNetworkDataSource.getContacts(page, results)

        val expectedResult = JsonData.getContactsResponse

        assertThat(actualContacts.results, hasItem(expectedResult))
    }

    @Test
    fun `GET CONTACTS - given a invalid page number return an error`() = runTest {
        try {
            stradivariusNetworkDataSource.getContacts(100000000)
        } catch(exception: Exception) {
            assertThat(exception.message, containsString("HTTP 404"))
        }
    }
}