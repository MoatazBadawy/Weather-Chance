package com.moataz.weather.data.request

sealed class NetworkResult<T>{
    class Success<T>(val transferredData: T) : NetworkResult<T>()
    class Failure<T>(message: String) : NetworkResult<T>()
    class Loading<T> : NetworkResult<T>()
}
