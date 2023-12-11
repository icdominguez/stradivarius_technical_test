package com.icdominguez.stradivariustechnicaltest.data.users.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.icdominguez.stradivariustechnicaltest.core.model.Contact
import com.icdominguez.stradivariustechnicaltest.core.network.StradivariusNetworkDataSource
import com.icdominguez.stradivariustechnicaltest.core.preferences.StradivariusPreferencesDataSource
import com.icdominguez.stradivariustechnicaltest.data.users.toContact
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultUsersRepository @Inject constructor(
    private val dataSource: StradivariusNetworkDataSource,
    private val preferencesDataSource: StradivariusPreferencesDataSource
) : UsersRepository {
    override suspend fun getAllUsers(): Flow<PagingData<Contact>> {
        return Pager(PagingConfig(pageSize = 20)) {
            UsersPagingSource(dataSource)
        }.flow
    }

    override fun retrieveUser(): String? =
        preferencesDataSource.getUser()

    override fun storeUser(user: String) {
        preferencesDataSource.setUser(user)
    }
}

class UsersPagingSource(
    private val dataSource: StradivariusNetworkDataSource,
) : PagingSource<Int, Contact>() {
    override fun getRefreshKey(state: PagingState<Int, Contact>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Contact> {
        val pageNumber = params.key ?: 1
        return try {
            val usersResponse = dataSource.getContacts(pageNumber)
            val users = usersResponse.results.map { getUserResult ->
                getUserResult.toContact()
            }

            LoadResult.Page(
                data = users,
                prevKey = if (pageNumber == 1) null else pageNumber - 1,
                nextKey = if (users.isEmpty()) null else pageNumber + 1,
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
