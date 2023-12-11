package com.icdominguez.stradivariustechnicaltest.core.network.di

import com.icdominguez.stradivariustechnicaltest.core.network.BuildConfig
import com.icdominguez.stradivariustechnicaltest.core.network.StradivariusNetworkApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val STRADIVARIUS_BASE_URL = "https://randomuser.me/"

    private fun okHttpClient(): OkHttpClient.Builder {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.connectTimeout(10, TimeUnit.SECONDS)
        okHttpClient.readTimeout(30, TimeUnit.SECONDS)
        okHttpClient.writeTimeout(30, TimeUnit.SECONDS)

        when {
            BuildConfig.DEBUG -> {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                okHttpClient.addInterceptor(logging)
            }
        }

        return okHttpClient
    }

    @ExperimentalSerializationApi
    @Singleton
    @Provides
    fun providesAPI(): StradivariusNetworkApi {
        val httpClient = okHttpClient()
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(STRADIVARIUS_BASE_URL)
            .client(httpClient.build())
            .build()
            .create(StradivariusNetworkApi::class.java)
    }
}