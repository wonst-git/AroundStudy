package com.aroundstudy.module

import com.aroundstudy.data.service.KakaoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object KakaoApiModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder().apply {
            connectTimeout(KakaoService.TIME_OUT, TimeUnit.SECONDS)
            writeTimeout(KakaoService.TIME_OUT, TimeUnit.SECONDS)
            readTimeout(KakaoService.TIME_OUT, TimeUnit.SECONDS)
            addInterceptor(HttpLoggingInterceptor())
        }.build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(KakaoService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    @Provides
    @Singleton
    fun provideKakaoService(retrofit: Retrofit): KakaoService = retrofit.create(KakaoService::class.java)
}