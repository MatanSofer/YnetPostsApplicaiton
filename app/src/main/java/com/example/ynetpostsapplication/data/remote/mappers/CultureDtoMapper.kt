import com.example.ynetpostsapplication.data.remote.DtoDateFormatter.formatDateString
import com.example.ynetpostsapplication.data.remote.model.CultureItemDto
import com.example.ynetpostsapplication.domain.models.Culture

fun CultureItemDto.toCulture(): Culture {
    return Culture(
        title = this.title,
        description = this.description,
        link = this.link,
        pubDate = formatDateString(this.pubDate),
        guid = this.guid,
        tags = this.tags
    )
}