package com.example.ynetpostsapplication.data.remote

import okhttp3.ResponseBody
import retrofit2.http.GET

interface SportApi {
    @GET("StoryRss3.xml")
    suspend fun getSportFeed(): ResponseBody
}