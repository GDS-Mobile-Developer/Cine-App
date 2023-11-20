package com.gdsdevtec.cineapp.utils

sealed class StateView<T>(
    open val data: T? = null,
    open val msg: String? = null,
) {
    object Loading : StateView<Nothing>(data = null, msg = null)
    data class Error(
        override val msg: String,
    ) : StateView<Nothing>(
        data = null, msg = msg
    )

    data class Success<T>(
        override val data: T,
        override val msg: String? = null,
    ) : StateView<T>(data = data, msg = msg)
}