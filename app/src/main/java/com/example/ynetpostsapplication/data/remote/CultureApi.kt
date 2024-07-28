package com.example.ynetpostsapplication.data.remote

import okhttp3.ResponseBody
import retrofit2.http.GET

interface CultureApi {
    @GET("StoryRss538.xml")
    suspend fun getCultureFeed(): ResponseBody
}