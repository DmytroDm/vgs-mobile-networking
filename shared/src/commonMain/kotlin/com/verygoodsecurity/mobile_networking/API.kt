package com.verygoodsecurity.mobile_networking

import com.verygoodsecurity.mobile_networking.model.HTTPMethod
import com.verygoodsecurity.mobile_networking.model.NetworkRequest
import com.verygoodsecurity.mobile_networking.model.NetworkResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpMethod
import io.ktor.http.headers
import io.ktor.http.isSuccess

class API {

    private val client = HttpClient()

    suspend fun execute(request: NetworkRequest): NetworkResponse {
        return client.request {
            url(request.url)
            method = request.method.map()
            headers {
                request.customHeaders.forEach {
                    set(it.key, it.value)
                }
            }
            setBody(request.customData)
        }.toNetworkResponse()
    }

    private fun HTTPMethod.map() = when(this) {
        HTTPMethod.POST -> HttpMethod.Post
        HTTPMethod.PUT -> HttpMethod.Put
        HTTPMethod.GET -> HttpMethod.Get
        HTTPMethod.PATCH -> HttpMethod.Patch
        HTTPMethod.DELETE -> HttpMethod.Delete
    }

    private suspend fun HttpResponse.toNetworkResponse(): NetworkResponse {
        println("TEST:DD, response =  $this")
        return NetworkResponse(
            isSuccessful = this.status.isSuccess(),
            body = this.body(),
            code = this.status.value,
            message = this.status.description,
            error = null
        ).apply {
            println("TEST:DD, mapped response = $this")
        }
    }
}