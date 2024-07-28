package com.example.ynetpostsapplication.di

import com.example.ynetpostsapplication.data.remote.CarsApi
import com.example.ynetpostsapplication.data.remote.CultureApi
import com.example.ynetpostsapplication.data.remote.SportApi
import com.example.ynetpostsapplication.data.repository.YnetRepositoryImp
import com.example.ynetpostsapplication.domain.YnetRepository
import com.example.ynetpostsapplication.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideCarsApi(): CarsApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
            .create(CarsApi :: class.java)
    }
    @Provides
    @Singleton
    fun provideSportApi(): SportApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
            .create(SportApi :: class.java)
    }
    @Provides
    @Singleton
    fun provideCultureApi(): CultureApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
            .create(CultureApi :: class.java)
    }
    @Provides
    @Singleton
    fun provideYnetRepository(carsApi: CarsApi, cultureApi: CultureApi, sportApi: SportApi): YnetRepository{
        return YnetRepositoryImp(carsApi,cultureApi,sportApi)
    }

}