package com.verygoodsecurity.mobile_netwroking

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform