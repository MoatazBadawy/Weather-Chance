package com.moataz.weather.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.moataz.weather.data.model.WeatherResponse
import com.moataz.weather.data.request.ApiClient
import com.moataz.weather.data.request.NetworkResult
import com.moataz.weather.databinding.ActivityMainBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
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

        val netWorkResult = Observable.create<NetworkResult<WeatherResponse>> { status ->
            status.onNext(NetworkResult.Loading())
            apiClient.makeApiRequest().enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    status.onNext(NetworkResult.Failure(e.message.toString()))
                }

                override fun onResponse(call: Call, response: Response) {
                    response.body?.string().let { jsonString ->
                        val transferredData =
                            Gson().fromJson(jsonString, WeatherResponse::class.java)
                        status.onNext(NetworkResult.Success(transferredData))
                    }
                }
            })
        }

        netWorkResult.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe { status ->
                when (status) {
                    is NetworkResult.Failure -> displayFailureState()
                    is NetworkResult.Loading -> displayLoadingState()
                    is NetworkResult.Success -> displayWeatherData(status)

                }
            }
    }

    private fun displayLoadingState() {
        TODO("Not yet implemented")
    }

    private fun displayFailureState() {
        TODO("Not yet implemented")
    }

    private fun displayWeatherData(status: NetworkResult.Success<WeatherResponse>) {
        binding.descriptionTxv.text = status.transferredData.data.first().weather.description
        binding.tem.text = "${status.transferredData.data.first().temp} °C"
        binding.sunset.text = status.transferredData.data.first().sunset
        binding.windSpeed.text = status.transferredData.data.first().wind_spd.toInt().toString()
        binding.rh.text = status.transferredData.data.first().rh.toInt().toString()
    }


}