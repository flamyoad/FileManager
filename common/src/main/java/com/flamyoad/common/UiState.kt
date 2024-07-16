package com.flamyoad.common

sealed interface UiState<out T> {
    data class Success<T>(val value: T) : UiState<T>
    data class Error(val exception: Throwable? = null, val message: String = ""): UiState<Nothing>
    data object Loading : UiState<Nothing>
}