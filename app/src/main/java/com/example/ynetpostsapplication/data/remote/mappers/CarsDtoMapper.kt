package com.example.ynetpostsapplication.data.remote.mappers

import com.example.ynetpostsapplication.data.remote.DtoDateFormatter.formatDateString
import com.example.ynetpostsapplication.data.remote.model.CarDto
import com.example.ynetpostsapplication.data.remote.model.CarItemDto
import com.example.ynetpostsapplication.domain.models.Car

fun CarItemDto.toCar(): Car {
    return Car(
        title = this.title,
        description = this.description,
        link = this.link,
        pubDate = formatDateString(this.pubDate),
        guid = this.guid,
        tags = this.tags
    )
}