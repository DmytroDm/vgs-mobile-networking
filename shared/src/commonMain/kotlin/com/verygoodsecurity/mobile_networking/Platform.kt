package com.verygoodsecurity.mobile_networking

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform