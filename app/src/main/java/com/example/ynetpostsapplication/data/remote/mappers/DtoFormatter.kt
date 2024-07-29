package com.example.ynetpostsapplication.data.remote.mappers

object DtoFormatter {
    fun formatDateString(dateStr: String?): String? {
        if (dateStr == null) return null
        return try {
            val parts = dateStr.split(", ", " +")
            if (parts.size >= 2) {
                parts[1].trim()
            } else {
                dateStr
            }
        } catch (e: Exception) {
            dateStr
        }
    }
}
