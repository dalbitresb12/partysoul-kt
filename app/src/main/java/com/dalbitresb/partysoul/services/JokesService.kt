package com.dalbitresb.partysoul.services

import com.dalbitresb.partysoul.dtos.DadJokesResponse
import com.dalbitresb.partysoul.models.Joke
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDateTime

class JokesService(private val endpoint: String) {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(endpoint)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(DadJokesService::class.java)

    fun fetch(callback: (Joke) -> Unit) {
        val joke = service.getJoke().enqueue(object : Callback<DadJokesResponse> {
            override fun onResponse(
                call: Call<DadJokesResponse>,
                response: Response<DadJokesResponse>
            ) {
                val body = response.body()
                if (body != null) {
                    val parsed = Joke(
                        source = "icanhazdadjoke",
                        jokeId = body.id,
                        content = body.joke,
                        rating = 0.0f,
                        createdAt = LocalDateTime.now().toString(),
                    )
                    callback(parsed)
                }
            }

            override fun onFailure(call: Call<DadJokesResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}