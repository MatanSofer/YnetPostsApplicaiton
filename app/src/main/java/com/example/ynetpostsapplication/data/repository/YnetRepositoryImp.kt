package com.example.ynetpostsapplication.data.repository

import com.example.ynetpostsapplication.data.remote.CarsApi
import com.example.ynetpostsapplication.data.remote.CultureApi
import com.example.ynetpostsapplication.data.remote.SportApi
import com.example.ynetpostsapplication.domain.YnetRepository
import com.example.ynetpostsapplication.domain.models.Car
import com.example.ynetpostsapplication.domain.models.Culture
import com.example.ynetpostsapplication.domain.models.Sport
import okhttp3.ResponseBody
import retrofit2.Response

class YnetRepositoryImp (
    private val carsApi: CarsApi,
    private val cultureApi: CultureApi,
    private val sportApi: SportApi
): YnetRepository{

    //    override suspend fun getPostsFromApi(): List<Post> {
//        return api.getCarsFeed().map {posts ->
//            posts.toPost()
//        }
//    }
    override suspend fun getCarFromApi(): List<Car> {
        val response = carsApi.getCarsFeed()
        return emptyList()
    }

    override suspend fun getCultureFromApi(): List<Culture> {
        val response = cultureApi.getCultureFeed()
        return emptyList()
    }

    override suspend fun getSportFromApi(): List<Sport> {
        val response = sportApi.getSportFeed()
        return emptyList()
    }
}