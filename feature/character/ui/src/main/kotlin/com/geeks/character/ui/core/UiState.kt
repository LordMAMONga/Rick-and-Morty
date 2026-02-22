package com.geeks.character.ui.core

import com.geeks.core.network.model.AppError
import com.geeks.core.network.model.DataResult

sealed interface UiState<out T> {
    data object NotLoaded : UiState<Nothing>
    data object Loading : UiState<Nothing>
    data class Success<T>(val data: T) : UiState<T>
    data class Error(val message: String) : UiState<Nothing>
}

fun <T, E: AppError> DataResult<T, E>.toUiState(): UiState<T> {
    return when (this) {
        is DataResult.Success -> UiState.Success(this.data)
        is DataResult.Error -> UiState.Error(
            message = this.error.asThrowable().message ?: "Неизвестная ошибка"
        )
    }
}