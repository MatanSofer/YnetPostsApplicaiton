package com.example.ynetpostsapplication.data.remote.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
data class SportDto(
    @field:Element(name = "channel")
    var channel: SportDtoChannel? = null
)

@Root(name = "channel", strict = false)
data class SportDtoChannel(
    @field:Element(name = "title")
    var title: String? = null,

    @field:Element(name = "link")
    var link: String? = null,

    @field:Element(name = "description")
    var description: String? = null,

    @field:ElementList(inline = true, name = "item")
    var items: List<SportItemDto>? = null
)

@Root(name = "item", strict = false)
data class SportItemDto(
    @field:Element(name = "title", required = false)
    var title: String? = null,

    @field:Element(name = "description", required = false)
    var description: String? = null,

    @field:Element(name = "link", required = false)
    var link: String? = null,

    @field:Element(name = "pubDate", required = false)
    var pubDate: String? = null,

    @field:Element(name = "guid", required = false)
    var guid: String? = null,

    @field:Element(name = "tags", required = false)
    var tags: String? = null
)
