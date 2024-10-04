package com.verygoodsecurity.mobile_networking.model

data class NetworkResponse(
    val isSuccessful: Boolean = false,
    val body: String? = null,
    val code: Int = -1,
    val message: String? = null,
    val error: VGSError? = null
)