package com.verygoodsecurity.mobile_networking.model

data class NetworkRequest(
    val method: HTTPMethod,
    var url: String,
    val customHeaders: Map<String, String>,
    val customData: Any,
    val fieldsIgnore: Boolean,
    val fileIgnore: Boolean,
    val format: VGSHttpBodyFormat,
    val requestTimeoutInterval: Long,
    val requiresTokenization: Boolean
)
