package com.androidstartercode2024.data.sources.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        // Add headers, api keys, tokens, etc
        // update refresh token if necessary
        // val url = ...

        request = request.newBuilder().url(request.url).build()
        return chain.proceed(request)

        // Remove return and intercept response if necessary
        // val response = chain.proceed(request)
        // If (response.code() == ...
        // return response
    }
}