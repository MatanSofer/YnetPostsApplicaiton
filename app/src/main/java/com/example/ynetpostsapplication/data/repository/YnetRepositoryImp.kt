package com.example.ynetpostsapplication.data.repository

import com.example.ynetpostsapplication.data.remote.CarsApi
import com.example.ynetpostsapplication.data.remote.CultureApi
import com.example.ynetpostsapplication.data.remote.SportApi
import com.example.ynetpostsapplication.data.remote.mappers.toCar
import com.example.ynetpostsapplication.data.remote.mappers.toSport
import com.example.ynetpostsapplication.domain.YnetRepository
import com.example.ynetpostsapplication.domain.models.Car
import com.example.ynetpostsapplication.domain.models.Culture
import com.example.ynetpostsapplication.domain.models.Sport
import toCulture

class YnetRepositoryImp (
    private val carsApi: CarsApi,
    private val cultureApi: CultureApi,
    private val sportApi: SportApi
): YnetRepository{

    override suspend fun getCarFromApi(): List<Car> {
        val response = carsApi.getCarsFeed()
        return response.channel?.items?.map { it.toCar() } ?: emptyList()
    }

    override suspend fun getCultureFromApi(): List<Culture> {
        val response = cultureApi.getCultureFeed()
        return response.channel?.items?.map { it.toCulture() } ?: emptyList()
    }

    override suspend fun getSportFromApi(): List<Sport> {
        val response = sportApi.getSportFeed()
        return response.channel?.items?.map { it.toSport() } ?: emptyList()
    }
}