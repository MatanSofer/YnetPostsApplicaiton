package com.example.ynetpostsapplication.presentation.open_screen.model


import androidx.lifecycle.ViewModel
import com.example.ynetpostsapplication.presentation.open_screen.OpenScreenUiAction
import com.example.ynetpostsapplication.utils.TimeManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class OpenScreenViewModel @Inject constructor(
    private val timeManager: TimeManager
) : ViewModel() {

    private val _state = MutableStateFlow(OpenScreenState())
    val state: StateFlow<OpenScreenState> = _state

    fun getTimeInfoFlow() = timeManager.time


    fun onAction(action: OpenScreenUiAction){
        when(action){
            OpenScreenUiAction.NavigateToListsScreen-> {
                //navController.navigate()
            }
        }
    }



}