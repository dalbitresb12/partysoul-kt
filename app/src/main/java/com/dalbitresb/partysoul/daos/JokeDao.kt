package com.dalbitresb.partysoul.daos

import androidx.room.*
import com.dalbitresb.partysoul.models.Joke

@Dao
interface JokeDao {
    @Query("SELECT * FROM joke")
    fun getAll(): List<Joke>

    @Query("SELECT * FROM joke WHERE joke_id LIKE :jokeId AND source LIKE :source LIMIT 1")
    fun findByJokeIdAndSource(jokeId: String, source: String): Joke

    @Query("SELECT * FROM joke WHERE content LIKE :content AND source LIKE :source LIMIT 1")
    fun findByContentAndSource(content: String, source: String): Joke

    @Update
    fun update(joke: Joke)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(joke: Joke)

    @Query("DELETE FROM joke")
    fun deleteAll()
}