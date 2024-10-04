package com.verygoodsecurity.mobile_networking.model

enum class VGSHttpBodyFormat {
    PLAIN_TEXT,
    JSON,
    X_WWW_FORM_URLENCODED
}

fun VGSHttpBodyFormat.toContentType() = when (this) {
    VGSHttpBodyFormat.JSON -> "application/json"
    VGSHttpBodyFormat.PLAIN_TEXT -> "text/plain"
    VGSHttpBodyFormat.X_WWW_FORM_URLENCODED -> "application/x-www-form-urlencoded"
}