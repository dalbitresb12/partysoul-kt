package com.dalbitresb.partysoul.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.dalbitresb.partysoul.models.Joke
import kotlinx.coroutines.flow.Flow

@Dao
interface JokeDao {
    @Query("SELECT * FROM joke")
    fun getAll(): Flow<List<Joke>>

    @Query("SELECT * FROM joke WHERE content LIKE :content LIMIT 1")
    fun findByContent(content: String): Joke

    @Update
    suspend fun updateAll(vararg jokes: Joke)

    @Insert
    suspend fun insertAll(vararg jokes: Joke)

    @Query("DELETE FROM joke")
    suspend fun deleteAll()
}