package com.dalbitresb.partysoul.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Joke(
    @ColumnInfo(name = "source") var source: String,
    @ColumnInfo(name = "joke_id") var jokeId: String?,
    @ColumnInfo(name = "content") var content: String,
    @ColumnInfo(name = "rating") var rating: Float,
    @ColumnInfo(name = "created_at") var createdAt: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}