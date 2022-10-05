package com.dalbitresb.partysoul

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dalbitresb.partysoul.adapters.JokeAdapter
import com.dalbitresb.partysoul.viewmodels.JokeViewModel
import com.dalbitresb.partysoul.viewmodels.JokeViewModelFactory
import com.google.android.material.appbar.MaterialToolbar

class JokesActivity : AppCompatActivity() {
    private val jokeViewModel: JokeViewModel by viewModels {
        JokeViewModelFactory((application as JokeApplication).repository)
    }

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
        val adapter = JokeAdapter { joke -> jokeViewModel.update(joke) }
        jokeViewModel.data.observe(this) { jokes -> adapter.submitList(jokes) }
        val recyclerView = findViewById<RecyclerView>(R.id.jokesRecyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
//        jokeViewModel.deleteAll()
//        jokeViewModel.insert(
//            Joke(
//                "geek",
//                null,
//                "Super fun joke 2",
//                4.5f,
//                "2022-10-03T18:20:45"
//            ),
//        )
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