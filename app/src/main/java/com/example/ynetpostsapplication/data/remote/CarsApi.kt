package com.example.ynetpostsapplication.data.remote

import okhttp3.ResponseBody
import retrofit2.http.GET

interface CarsApi {
    @GET("StoryRss550.xml")
    suspend fun getCarsFeed(): ResponseBody
}