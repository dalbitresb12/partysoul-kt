package com.dalbitresb.partysoul

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.dalbitresb.partysoul.adapters.JokeAdapter
import com.dalbitresb.partysoul.models.Joke
import com.google.android.material.appbar.MaterialToolbar

class JokesActivity : AppCompatActivity() {
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
        val jokes = ArrayList<Joke>()
        jokes.add(Joke("Joke 1", "Source A"))
        jokes.add(Joke("Joke 2", "Source B"))
        jokes.add(Joke("Joke 3", "Source A"))

        val recyclerView = findViewById<RecyclerView>(R.id.jokesRecyclerView)
        recyclerView.adapter = JokeAdapter(jokes)
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