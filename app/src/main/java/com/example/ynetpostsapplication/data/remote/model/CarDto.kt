package com.example.ynetpostsapplication.data.remote.model

import java.util.Date

data class CarDto(
    val channel: Channel
)

data class CarChannel(
    val title: String,
    val link: String,
    val description: String,
    val copyright: String,
    val language: String,
    val pubDate: String,
    val lastBuildDate: String,
    val image: Image,
    val items: List<Item>
)

data class CarImage(
    val title: String,
    val link: String,
    val url: String
)

data class CarItem(
    val title: String,
    val description: String,
    val link: String,
    val pubDate: String,
    val guid: String,
    val tags: List<String>
)
