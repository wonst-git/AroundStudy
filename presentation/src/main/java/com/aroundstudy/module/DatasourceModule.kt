package com.aroundstudy.module

import android.content.Context
import androidx.room.Room
import com.aroundstudy.data.service.SearchHistoryDao
import com.aroundstudy.data.database.AppDatabase
import com.aroundstudy.data.datasource.preference.PreferenceDataSourceImpl
import com.aroundstudy.data.datasource.preference.PreferenceDatasource
import com.aroundstudy.data.datasource.room.SearchHistoryDataSource
import com.aroundstudy.data.datasource.room.SearchHistoryDataSourceImpl
import com.aroundstudy.data.datasource.server.KakaoAddressDataSource
import com.aroundstudy.data.datasource.server.KakaoAddressDataSourceImpl
import com.aroundstudy.data.datasource.server.KakaoCoordToAddressDataSource
import com.aroundstudy.data.datasource.server.KakaoCoordToAddressDataSourceImpl
import com.aroundstudy.data.service.KakaoService
import com.aroundstudy.data.service.PreferenceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatasourceModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context)
            : AppDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "aroundStudy.db").build()

    @Provides
    @Singleton
    fun provideSearchHistoryDao(appDatabase: AppDatabase): SearchHistoryDao = appDatabase.searchHistoryDao()

    @Provides
    @Singleton
    fun providePreferenceManager(@ApplicationContext context: Context): PreferenceManager = PreferenceManager(context)

    @Provides
    @Singleton
    fun providePreferenceDataSource(preferenceManager: PreferenceManager): PreferenceDatasource = PreferenceDataSourceImpl(preferenceManager)

    @Provides
    @Singleton
    fun provideSearchHistoryDataSource(searchHistoryDao: SearchHistoryDao): SearchHistoryDataSource = SearchHistoryDataSourceImpl(searchHistoryDao)

    @Provides
    @Singleton
    fun provideKakaoAddressDataSource(kakaoService: KakaoService): KakaoAddressDataSource = KakaoAddressDataSourceImpl(kakaoService)

    @Provides
    @Singleton
    fun provideKakaoToAddressDataSource(kakaoService: KakaoService): KakaoCoordToAddressDataSource = KakaoCoordToAddressDataSourceImpl(kakaoService)
}