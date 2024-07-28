package com.example.ynetpostsapplication.data.remote.mappers

import com.example.ynetpostsapplication.data.remote.model.CultureDto
import com.example.ynetpostsapplication.data.remote.model.SportDto
import com.example.ynetpostsapplication.domain.models.Culture
import com.example.ynetpostsapplication.domain.models.Sport

fun SportDto.toSport(): Sport {
    return Sport(
        title = ""
    )
}