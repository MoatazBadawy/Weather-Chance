package com.core.remote.authentication

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import com.core.remote.authentication.BuildConfig.API_KEY

class AuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
            .url
            .newBuilder()
            .addQueryParameter(API_KEY_WEATHER, API_KEY)
            .build()

        return chain.proceed(chain.request().newBuilder().url(original).build())
    }

    companion object {
        private const val API_KEY_WEATHER = "Key"
    }
}