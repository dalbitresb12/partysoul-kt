package com.dalbitresb.partysoul.services

import com.dalbitresb.partysoul.dtos.GeekJokeResponse
import com.dalbitresb.partysoul.models.Joke
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDateTime

class GeekJokesFetcher(endpoint: String) {
    private val retrofit: Retrofit =
        Retrofit.Builder().baseUrl(endpoint).addConverterFactory(GsonConverterFactory.create())
            .build()

    private val service = retrofit.create(GeekJokesService::class.java)

    fun fetch(callback: (Joke) -> Unit) {
        service.getJoke().enqueue(object : Callback<GeekJokeResponse> {
            override fun onResponse(call: Call<GeekJokeResponse>, res: Response<GeekJokeResponse>) {
                if (res.isSuccessful) {
                    val body = res.body()
                    if (body != null) {
                        val parsed = Joke(
                            source = "Geek Joke API",
                            content = body.joke,
                            rating = 0.0f,
                            createdAt = LocalDateTime.now().toString(),
                        )
                        callback(parsed)
                    }
                }
                // TODO: Show toast on failed request
            }

            override fun onFailure(call: Call<GeekJokeResponse>, t: Throwable) {
                // TODO: Show toast on failed request
                throw t
            }
        })
    }
}