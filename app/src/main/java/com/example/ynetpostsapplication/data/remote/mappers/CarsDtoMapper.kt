package com.example.ynetpostsapplication.data.remote.mappers

import com.example.ynetpostsapplication.data.remote.model.CarDto
import com.example.ynetpostsapplication.domain.models.Car

fun CarDto.toCar(): Car {
    return Car(
        title = ""
    )
}