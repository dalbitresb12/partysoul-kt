package com.dalbitresb.partysoul

import android.app.Application
import com.dalbitresb.partysoul.repositories.JokeRepository

class JokeApplication : Application() {
    private val database by lazy { JokeDatabase.getInstance(this) }
    val repository by lazy { JokeRepository(database.jokeDao()) }
}