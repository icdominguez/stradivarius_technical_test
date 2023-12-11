package com.icdominguez.stradivariustechnicaltest.core.network.di

import com.icdominguez.stradivariustechnicaltest.core.network.StradivariusNetwork
import com.icdominguez.stradivariustechnicaltest.core.network.StradivariusNetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkBindings {

    @Binds
    abstract fun bindUsersNetworkDataSource(
        usersNetworkDataSource: StradivariusNetwork
    ): StradivariusNetworkDataSource
}