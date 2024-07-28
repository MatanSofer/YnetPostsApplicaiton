package com.example.ynetpostsapplication.presentation.lists_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ynetpostsapplication.domain.cars.GetCarsUseCase
import com.example.ynetpostsapplication.domain.culture.GetCultureUseCase
import com.example.ynetpostsapplication.domain.sport.GetSportUseCase
import com.example.ynetpostsapplication.presentation.lists_screen.model.ListScreenState
import com.example.ynetpostsapplication.utils.Constants.POLLING_INTERVAL
import com.example.ynetpostsapplication.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class ListScreenViewModel  @Inject constructor(
    private val getCarsUseCase: GetCarsUseCase,
    private val getCultureUseCase: GetCultureUseCase,
    private val getSportUseCase: GetSportUseCase
): ViewModel() {

    private val _state = MutableStateFlow(ListScreenState())
    val state: StateFlow<ListScreenState> = _state

    init {
        getCarsList()
        getSportsList()
        getCultureList()
    }

    private fun getCarsList(){
        viewModelScope.launch(Dispatchers.IO) {
            getCarsUseCase().collect{ result ->
                when(result){
                    is Resource.Success -> {
                        _state.value = _state.value.copy(
                            cars = result.data ?: emptyList()
                        )
                    }
                    is Resource.Error -> {
                        // we can add later error handle
                    }
                    is Resource.Loading -> {
                        //_state.value = _state.value.copy(firstTabIsLoading = true)
                    }
                }
            }
        }
    }
    private fun getSportsList(){
        viewModelScope.launch(Dispatchers.IO) {
            getSportUseCase().collect{ result ->
                when(result){
                    is Resource.Success -> {
                        _state.value = _state.value.copy(
                            sports = result.data ?: emptyList(),
                            secondTabIsLoading = false
                        )
                        //startPollingSportList()
                    }
                    is Resource.Error -> {
                        _state.value = _state.value.copy(
                            secondTabIsLoading = false
                        )
                    }
                    is Resource.Loading -> {
                        _state.value = _state.value.copy(secondTabIsLoading = true)
                    }
                }
            }
        }
    }

    private fun getCultureList(){
        viewModelScope.launch(Dispatchers.IO) {
            getCultureUseCase().collect{ result ->
                when(result){
                    is Resource.Success -> {
                        _state.value = _state.value.copy(
                            culture = result.data ?: emptyList()
                        )
                        //startPollingCultureList()

                    }
                    is Resource.Error -> {
                        // we can add later error handle
//                        delay(POLLING_INTERVAL)
//                        startPollingCultureList()
                    }
                    is Resource.Loading -> {
                        _state.value = _state.value.copy(secondTabIsLoading = true)
                    }
                }
            }
        }
    }
    private fun startPollingSportList() {
         viewModelScope.launch {
            while (true) {
                getSportsList()
                delay(POLLING_INTERVAL)
            }
        }
    }
    private fun startPollingCultureList() {
        viewModelScope.launch {
            while (true) {
                getCultureList()
                delay(POLLING_INTERVAL)
            }
        }
    }
    fun onAction(action: ListScreenUiAction){
        when(action){
            is ListScreenUiAction.NavigateBackWithTitle-> {
                //navController.navigateUp()
            }
            is ListScreenUiAction.OpenWebView -> {

            }
        }
    }

}