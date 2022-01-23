package com.github.mobdev778.yusupova.app.repository.remote.retrofit.di

import android.util.Log
import com.github.mobdev778.yusupova.app.core.data.repository.app.IAppConfigRepository
import com.github.mobdev778.yusupova.app.core.di.AppScope
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@Module
class RetrofitModule {

    @LoggingInterceptor
    @Provides
    fun providesLoggingInterceptor(): Interceptor {
        val logger = HttpLoggingInterceptor.Logger {
                message -> Log.d("Http", message)
        }
        val interceptor = HttpLoggingInterceptor(logger)
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @AppScope
    @Provides
    fun providesOkHttp(
        @LoggingInterceptor loggingInterceptor: Interceptor
    ): OkHttpClient {
        val client = OkHttpClient.Builder()
            client.connectTimeout(10, TimeUnit.SECONDS)
            client.readTimeout(10, TimeUnit.SECONDS)
            client.writeTimeout(10, TimeUnit.SECONDS)
            client.addInterceptor(loggingInterceptor)
        return client.build()
    }

    @AppScope
    @Provides
    fun providesMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @AppScope
    @Provides
    fun providesRetrofit(
        appConfigRepository: IAppConfigRepository,
        moshi: Moshi,
        okHttpClient: OkHttpClient
    ): Retrofit {
        val serverUrl = appConfigRepository.serverUrl
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(serverUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

}