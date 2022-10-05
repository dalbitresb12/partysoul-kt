package com.dalbitresb.partysoul

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadInitialJoke()
        setupButtonListener()
    }

    private fun loadInitialJoke() {
        val textView = findViewById<TextView>(R.id.jokeTextView)
        textView.text = getString(R.string.noJokesText)
    }

    private fun setupButtonListener() {
        val button = findViewById<Button>(R.id.jokeActivityButton)
        button.setOnClickListener {
            val intent = Intent(this, JokesActivity::class.java)
            startActivity(intent)
        }
    }
}