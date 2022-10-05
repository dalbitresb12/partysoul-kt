package com.dalbitresb.partysoul.services

import com.dalbitresb.partysoul.dtos.GeekJokeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface GeekJokesService {
    @GET("/api")
    @Headers("User-Agent: PartySoul (https://github.com/dalbitresb12/partysoul-kt)")
    fun getJoke(@Query("format") format: String = "json"): Call<GeekJokeResponse>
}