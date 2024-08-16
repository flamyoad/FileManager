package com.flamyoad.common_ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

abstract class BaseViewModel: ViewModel() {

    fun <T> Flow<T>.toStateFlow(
        initialState: T,
        stopTimeoutMillis: Long = 500L
    ): StateFlow<T> {
            return stateIn(
                scope = this@BaseViewModel.viewModelScope,
                started = SharingStarted.WhileSubscribed(stopTimeoutMillis = stopTimeoutMillis),
                initialValue = initialState,
            )
    }
}