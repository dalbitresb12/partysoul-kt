package com.dalbitresb.partysoul

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dalbitresb.partysoul.adapters.JokeAdapter
import com.dalbitresb.partysoul.models.Joke
import com.google.android.material.appbar.MaterialToolbar

class JokesActivity : AppCompatActivity() {
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

        // TODO: Make network requests here
        val button = findViewById<Button>(R.id.addButton)
        button.setOnClickListener {
            val list = adapter.currentList.toMutableList()
            list.add(
                Joke(
                    source = "geek",
                    jokeId = null,
                    content = "Super fun joke 1",
                    rating = .5f,
                    createdAt = "2022-10-03T18:20:45",
                )
            )
            adapter.submitList(list)
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