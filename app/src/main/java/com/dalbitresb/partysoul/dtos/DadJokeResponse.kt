package com.dalbitresb.partysoul.dtos

import com.google.gson.annotations.SerializedName

class DadJokeResponse {
    @SerializedName("id")
    lateinit var id: String

    @SerializedName("joke")
    lateinit var joke: String

    @SerializedName("status")
    var status: Int = 0
}