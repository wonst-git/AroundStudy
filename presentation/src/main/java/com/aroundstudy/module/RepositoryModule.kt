package com.aroundstudy.module

import com.aroundstudy.data.datasource.preference.PreferenceDatasource
import com.aroundstudy.data.datasource.room.SearchHistoryDataSource
import com.aroundstudy.data.datasource.server.KakaoAddressDataSource
import com.aroundstudy.data.datasource.server.KakaoCoordToAddressDataSource
import com.aroundstudy.data.repository.KakaoAddressRepositoryImpl
import com.aroundstudy.data.repository.KakaoCoordToAddressRepositoryImpl
import com.aroundstudy.data.repository.PreferenceRepositoryImpl
import com.aroundstudy.data.repository.SearchHistoryRepositoryImpl
import com.aroundstudy.domain.repository.database.SearchHistoryRepository
import com.aroundstudy.domain.repository.preference.PreferenceRepository
import com.aroundstudy.domain.repository.server.KakaoAddressRepository
import com.aroundstudy.domain.repository.server.KakaoCoordToAddressRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideSearchHistoryRepository(searchHistoryDataSource: SearchHistoryDataSource): SearchHistoryRepository = SearchHistoryRepositoryImpl(searchHistoryDataSource)

    @Provides
    @Singleton
    fun providePreferenceRepository(preferenceDatasource: PreferenceDatasource): PreferenceRepository = PreferenceRepositoryImpl(preferenceDatasource)

    @Provides
    @Singleton
    fun provideKakaoAddressRepository(kakaoAddressDataSource: KakaoAddressDataSource): KakaoAddressRepository = KakaoAddressRepositoryImpl(kakaoAddressDataSource)

    @Provides
    @Singleton
    fun provideKakaoCoordToAddressRepository(kakaoCoordToAddressDataSource: KakaoCoordToAddressDataSource): KakaoCoordToAddressRepository =
        KakaoCoordToAddressRepositoryImpl(kakaoCoordToAddressDataSource)
}