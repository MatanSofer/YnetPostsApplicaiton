package com.example.ynetpostsapplication.data.remote.model

import java.util.Date

data class CultureImage(
    val title: String,
    val link: String,
    val url: String
)

data class CultureItem(
    val title: String,
    val description: String,
    val link: String,
    val pubDate: Date,
    val guid: String,
    val tags: List<String>
)

data class CultureDto(
    val title: String,
    val link: String,
    val description: String,
    val copyright: String,
    val language: String,
    val pubDate: Date,
    val image: CultureImage,
    val lastBuildDate: Date,
    val items: List<CultureItem>
)
