package com.dalbitresb.partysoul

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dalbitresb.partysoul.adapters.JokeAdapter
import com.dalbitresb.partysoul.models.Joke
import com.dalbitresb.partysoul.services.DadJokesFetcher
import com.dalbitresb.partysoul.services.GeekJokesFetcher
import com.google.android.material.appbar.MaterialToolbar
import kotlin.random.Random

class JokesActivity : AppCompatActivity() {
    private val dadJokesFetcher = DadJokesFetcher("https://icanhazdadjoke.com/")
    private val geekJokesFetcher = GeekJokesFetcher("https://geek-jokes.sameerkumar.website/")
    private val jokeRepository by lazy { (application as JokeApplication).repository }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jokes)
        setupBackButton()
        setupRecyclerView()
    }

    private fun setupBackButton() {
        val toolbar = findViewById<MaterialToolbar>(R.id.matToolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupRecyclerView() {
        val adapter = JokeAdapter { joke -> jokeRepository.insert(joke) }
        val recyclerView = findViewById<RecyclerView>(R.id.jokesRecyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.submitList(jokeRepository.getAll())

        val button = findViewById<Button>(R.id.addButton)
        button.setOnClickListener {
            val list = adapter.currentList.toMutableList()
            val handler = { joke: Joke ->
                list.add(joke)
                adapter.submitList(list)
            }
            // Select randomly the next API to use
            if (Random.nextBoolean()) {
                dadJokesFetcher.fetch(handler)
            } else {
                geekJokesFetcher.fetch(handler)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle arrow click
        if (item.itemId == android.R.id.home) {
            // Close this activity and go to the previous activity (if any)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}