import com.example.ynetpostsapplication.data.remote.model.CultureDto
import com.example.ynetpostsapplication.domain.models.Culture

fun CultureDto.toCulture(): Culture {
    return Culture(
        title = ""
    )
}