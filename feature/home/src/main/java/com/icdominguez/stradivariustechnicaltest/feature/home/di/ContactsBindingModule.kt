package com.icdominguez.stradivariustechnicaltest.feature.home.di

import com.icdominguez.stradivariustechnicaltest.feature.home.serializer.ContactSerializer
import com.icdominguez.stradivariustechnicaltest.feature.home.serializer.GsonContactSerializer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ContactsBindingModule {
    @Binds
    internal abstract fun bindContactSerializer(
        gsonContactSerializer: GsonContactSerializer
    ): ContactSerializer
}