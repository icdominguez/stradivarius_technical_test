package com.icdominguez.stradivariustechnicaltest.feature.detail.di

import com.icdominguez.stradivariustechnicaltest.feature.detail.deserializer.ContactDeserializer
import com.icdominguez.stradivariustechnicaltest.feature.detail.deserializer.GsonContactDeserializer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DetailBindingModule {
    @Binds
    internal abstract fun bindContactDeserializer(
        gsonContactDeserializer: GsonContactDeserializer
    ): ContactDeserializer
}