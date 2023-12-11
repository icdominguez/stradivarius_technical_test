package com.icdominguez.stradivariustechnicaltest.data.users.repository

import androidx.paging.PagingData
import com.icdominguez.stradivariustechnicaltest.core.model.Contact
import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    suspend fun getAllUsers(): Flow<PagingData<Contact>>
    fun storeUser(user: String)
    fun retrieveUser(): String?
}