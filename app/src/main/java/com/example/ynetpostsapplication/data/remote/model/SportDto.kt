package com.example.ynetpostsapplication.data.remote.model

data class SportDto(
    val channel: Channel
)

data class Channel(
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

data class Image(
    val title: String,
    val link: String,
    val url: String
)

data class Item(
    val title: String,
    val description: String,
    val link: String,
    val pubDate: String,
    val guid: String,
    val tags: List<String>
)
