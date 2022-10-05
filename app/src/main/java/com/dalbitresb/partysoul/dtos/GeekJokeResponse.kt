package com.dalbitresb.partysoul.dtos

import com.google.gson.annotations.SerializedName

class GeekJokeResponse {
    @SerializedName("joke")
    lateinit var joke: String
}