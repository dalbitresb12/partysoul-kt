package com.dalbitresb.partysoul.repositories

import com.dalbitresb.partysoul.daos.JokeDao
import com.dalbitresb.partysoul.models.Joke

class JokeRepository(private val jokeDao: JokeDao) {
    fun getAll(): List<Joke> {
        return jokeDao.getAll()
    }

    fun findByJokeIdAndSource(jokeId: String, source: String): Joke {
        return jokeDao.findByJokeIdAndSource(jokeId, source)
    }

    fun findByContentAndSource(content: String, source: String): Joke {
        return jokeDao.findByContentAndSource(content, source)
    }

    fun update(joke: Joke) {
        jokeDao.update(joke)
    }

    fun insert(joke: Joke) {
        jokeDao.insert(joke)
    }

    fun deleteAll() {
        jokeDao.deleteAll()
    }
}