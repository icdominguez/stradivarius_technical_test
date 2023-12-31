package com.icdominguez.stradivariustechnicaltest.core.preferences.di

import android.content.Context
import android.content.SharedPreferences
import com.icdominguez.stradivariustechnicaltest.core.preferences.PreferencesHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object PreferencesModule {
    @Provides
    fun provideSharedPreferences(
        @ApplicationContext context: Context
    ): SharedPreferences = PreferencesHelper.getPrefs(context)
}