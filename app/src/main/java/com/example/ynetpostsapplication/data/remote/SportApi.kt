package com.example.ynetpostsapplication.data.remote

import com.example.ynetpostsapplication.data.remote.model.SportDto
import retrofit2.http.GET

interface SportApi {
    @GET("StoryRss3.xml")
    suspend fun getSportFeed(): SportDto
}