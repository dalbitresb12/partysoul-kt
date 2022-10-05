package com.dalbitresb.partysoul.repositories

import com.dalbitresb.partysoul.daos.JokeDao
import com.dalbitresb.partysoul.models.Joke

class JokeRepository(private val jokeDao: JokeDao) {
    val data = jokeDao.getAll()

    suspend fun update(joke: Joke) {
        jokeDao.updateAll(joke)
    }

    suspend fun insert(joke: Joke) {
        jokeDao.insertAll(joke)
    }

    suspend fun deleteAll() {
        jokeDao.deleteAll()
    }
}