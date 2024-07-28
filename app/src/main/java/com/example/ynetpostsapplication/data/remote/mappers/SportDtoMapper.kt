package com.example.ynetpostsapplication.data.remote.mappers

import com.example.ynetpostsapplication.data.remote.DtoDateFormatter.formatDateString
import com.example.ynetpostsapplication.data.remote.model.SportItemDto
import com.example.ynetpostsapplication.domain.models.Sport


fun SportItemDto.toSport(): Sport {
    return Sport(
        title = this.title,
        description = this.description,
        link = this.link,
        pubDate = formatDateString(this.pubDate),
        guid = this.guid,
        tags = this.tags
    )
}