package com.dalbitresb.partysoul.services

import com.dalbitresb.partysoul.dtos.DadJokesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface DadJokesService {
    @GET
    @Headers(
        "Accept: application/json",
        "User-Agent: PartySoul (https://github.com/dalbitresb12/partysoul-kt)",
    )
    fun getJoke(): Call<DadJokesResponse>
}