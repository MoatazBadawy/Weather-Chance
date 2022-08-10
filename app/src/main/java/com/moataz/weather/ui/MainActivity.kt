package com.moataz.weather.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.moataz.weather.data.model.Data
import com.moataz.weather.data.model.WeatherResponse
import com.moataz.weather.data.request.ApiClient
import com.moataz.weather.data.request.NetworkResult
import com.moataz.weather.databinding.ActivityMainBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val apiClient by lazy { ApiClient() }


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var netWorkResult = Observable.create<NetworkResult<WeatherResponse>> { result ->
            result.onNext(NetworkResult.Loading())
            apiClient.makeApiRequest().enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    result.onNext(NetworkResult.Failure(e.message.toString()))
                }

                override fun onResponse(call: Call, response: Response) {
                    response.body?.string().let { jsonString ->
                        val transferredData = Gson().fromJson(jsonString, WeatherResponse::class.java)
                        result.onNext(NetworkResult.Success(transferredData))
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