package com.dalbitresb.partysoul

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dalbitresb.partysoul.daos.JokeDao
import com.dalbitresb.partysoul.models.Joke

@Database(entities = [Joke::class], version = 1, exportSchema = false)
abstract class JokeDatabase : RoomDatabase() {
    abstract fun jokeDao(): JokeDao

    companion object {
        @Volatile
        private var instance: JokeDatabase? = null

        fun getInstance(context: Context): JokeDatabase {
            return instance ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    JokeDatabase::class.java,
                    "jokes_db"
                ).build()
                this.instance = instance
                return instance
            }
        }
    }
}