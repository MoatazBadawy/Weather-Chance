package com.moataz.weather.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.moataz.weather.data.model.Data
import com.moataz.weather.data.model.WeatherResponse
import com.moataz.weather.data.request.ApiClient
import com.moataz.weather.data.request.NetworkResult
import com.moataz.weather.databinding.ActivityMainBinding
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val apiClient by lazy { ApiClient() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //getList()
        var netWorkStates = Observable.create<NetworkResult<WeatherResponse>> { state ->
            apiClient.makeApiRequest().enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    state.onNext(NetworkResult.Loading())
                    state.onNext(NetworkResult.Failure(e.message.toString()))
                }

                override fun onResponse(call: Call, response: Response) {
                    response.body?.string().let { jsonString ->
                        val result = Gson().fromJson(jsonString, WeatherResponse::class.java)
                        state.onNext(NetworkResult.Loading())
                        state.onNext(NetworkResult.Success(result))
                    }
                }
            })
        }
    }

    private fun getList() {
        apiClient.makeApiRequest().enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }

            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call, response: Response) {
                response.body?.string().let { jsonString ->
                    val result = Gson().fromJson(jsonString, WeatherResponse::class.java)
                    runOnUiThread {
                        binding.descriptionTxv.text = result.data[0].weather.description
                        binding.tem.text = "${result.data[0].temp} °C"
                        binding.sunset.text = result.data[0].sunset
                        binding.windSpeed.text = result.data[0].wind_spd.toInt().toString()
                        binding.rh.text = result.data[0].rh.toInt().toString()
                    }
                }
            }
        })
    }
}