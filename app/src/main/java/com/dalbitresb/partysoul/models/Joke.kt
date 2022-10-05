package com.dalbitresb.partysoul.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Joke(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "source")
    var source: String,

    @ColumnInfo(name = "joke_id")
    var jokeId: String? = null,

    @ColumnInfo(name = "content")
    var content: String,

    @ColumnInfo(name = "rating")
    var rating: Float,

    @ColumnInfo(name = "created_at")
    var createdAt: String,
)