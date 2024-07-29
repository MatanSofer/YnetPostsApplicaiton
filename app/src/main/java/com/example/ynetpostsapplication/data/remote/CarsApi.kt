package com.example.ynetpostsapplication.data.remote

import com.example.ynetpostsapplication.data.remote.model.CarDto
import retrofit2.http.GET

interface CarsApi {
    @GET("StoryRss550.xml")
    suspend fun getCarsFeed(): CarDto
}