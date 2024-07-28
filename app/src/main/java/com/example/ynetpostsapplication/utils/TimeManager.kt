package com.example.ynetpostsapplication.utils

import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject


class TimeManager @Inject constructor() {

    private val _time = MutableStateFlow(getCurrentDateTime())
    val time: StateFlow<String> = _time.asStateFlow()

    init {
        listenToTimeChanges()
    }

    private fun listenToTimeChanges() {
        tickerFlow(1000)
            .map { getCurrentDateTime() }
            .distinctUntilChanged()
            .onEach {
                _time.value = it
            }
            .launchIn(CoroutineScope(Dispatchers.IO))
    }

    private fun tickerFlow(period: Long) = flow {
        delay(period)
        while (true) {
            emit(Unit)
            delay(period)
        }
    }

    private fun getCurrentDateTime(): String {
        val now = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        return now.format(formatter)
    }
}