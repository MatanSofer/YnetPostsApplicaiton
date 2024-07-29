package com.example.ynetpostsapplication.data.remote

import com.example.ynetpostsapplication.data.remote.model.CultureDto
import retrofit2.http.GET

interface CultureApi {
    @GET("StoryRss538.xml")
    suspend fun getCultureFeed(): CultureDto
}