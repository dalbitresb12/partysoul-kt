package com.dalbitresb.partysoul.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dalbitresb.partysoul.R
import com.dalbitresb.partysoul.models.Joke

class JokeAdapter(private val data: List<Joke>) : RecyclerView.Adapter<JokeAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val jokeTextView: TextView
        private val sourceTextView: TextView

        init {
            jokeTextView = view.findViewById(R.id.cardJokeTextView)
            sourceTextView = view.findViewById(R.id.cardSourceTextView)
        }

        fun bind(joke: Joke) {
            jokeTextView.text = joke.content
            sourceTextView.text = joke.source
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.joke_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}