package com.icdominguez.stradivariustechnicaltest.core.preferences.di

import com.icdominguez.stradivariustechnicaltest.core.preferences.LocalStradivariusPreferencesDataSource
import com.icdominguez.stradivariustechnicaltest.core.preferences.StradivariusPreferencesDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PreferencesBinding {
    @Binds
    abstract fun bindStradivariusPreferencesDataSource(
        localStradivariusPreferencesDataSource: LocalStradivariusPreferencesDataSource
    ): StradivariusPreferencesDataSource
}