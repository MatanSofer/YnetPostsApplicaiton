package com.example.ynetpostsapplication.presentation.lists_screen

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ynetpostsapplication.domain.cars.GetCarsUseCase
import com.example.ynetpostsapplication.domain.culture.GetCultureUseCase
import com.example.ynetpostsapplication.domain.sport.GetSportUseCase
import com.example.ynetpostsapplication.presentation.lists_screen.model.ListScreenState
import com.example.ynetpostsapplication.utils.Constants.POLLING_INTERVAL
import com.example.ynetpostsapplication.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ListScreenViewModel @Inject constructor(
    private val getCarsUseCase: GetCarsUseCase,
    private val getCultureUseCase: GetCultureUseCase,
    private val getSportUseCase: GetSportUseCase,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _state = MutableStateFlow(ListScreenState())
    val state: StateFlow<ListScreenState> = _state

    init {
        getCarsList()
        getSportsList()
        getCultureList()
    }

    private fun getCarsList() {
        viewModelScope.launch {
            while (true) {
                getCarsUseCase().collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            _state.value = _state.value.copy(
                                cars = result.data ?: emptyList(),
                                carsItemsAreLoading = false
                            )
                            delay(POLLING_INTERVAL)
                        }

                        is Resource.Error -> {
                            _state.value = _state.value.copy(
                                carsItemsAreLoading = false
                            )
                            delay(POLLING_INTERVAL)
                        }

                        is Resource.Loading -> {
                            _state.value = _state.value.copy(carsItemsAreLoading = true)
                        }
                    }
                }
            }
        }
    }
    private fun getSportsList() {
        viewModelScope.launch {
            while (true) {
                getSportUseCase().collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            _state.value = _state.value.copy(
                                sports = result.data ?: emptyList(),
                                sportItemsAreLoading = false
                            )
                            delay(POLLING_INTERVAL)
                        }

                        is Resource.Error -> {
                            _state.value = _state.value.copy(
                                sportItemsAreLoading = false
                            )
                            delay(POLLING_INTERVAL)
                        }

                        is Resource.Loading -> {
                            _state.value = _state.value.copy(sportItemsAreLoading = true)
                        }
                    }
                }
            }
        }
    }

    private fun getCultureList() {
        viewModelScope.launch {
            while (true) {
                getCultureUseCase().collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            _state.value = _state.value.copy(
                                culture = result.data ?: emptyList(),
                                cultureItemsAreLoading = false
                            )
                            delay(POLLING_INTERVAL)
                        }

                        is Resource.Error -> {
                            _state.value = _state.value.copy(
                                cultureItemsAreLoading = false
                            )
                            delay(POLLING_INTERVAL)
                        }

                        is Resource.Loading -> {
                            _state.value = _state.value.copy(cultureItemsAreLoading = true)
                        }
                    }
                }
            }
        }
    }

    fun onAction(action: ListScreenUiAction) {
        when (action) {
            is ListScreenUiAction.OpenWebView -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(action.link)).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                context.startActivity(intent)
            }
        }
    }
}