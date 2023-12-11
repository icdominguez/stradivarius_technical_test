package com.icdominguez.stradivariustechnicaltest.data.users.di

import com.icdominguez.stradivariustechnicaltest.data.users.repository.DefaultUsersRepository
import com.icdominguez.stradivariustechnicaltest.data.users.repository.UsersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindCharactersRepository(
        defaultCharactersRepository: DefaultUsersRepository,
    ): UsersRepository
}