package com.dalbitresb.partysoul.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dalbitresb.partysoul.R
import com.dalbitresb.partysoul.models.Joke

class JokeAdapter(private val onClick: (Joke) -> Unit) :
    ListAdapter<Joke, JokeAdapter.ViewHolder>(JokesComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.joke_item, parent, false)
        return ViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class ViewHolder(view: View, val onClick: (Joke) -> Unit) :
        RecyclerView.ViewHolder(view) {
        private lateinit var joke: Joke
        private val jokeTextView: TextView
        private val sourceTextView: TextView
        private val ratingBar: RatingBar

        init {
            jokeTextView = view.findViewById(R.id.cardJokeTextView)
            sourceTextView = view.findViewById(R.id.cardSourceTextView)
            ratingBar = view.findViewById(R.id.cardRatingBar)
            ratingBar.setOnRatingBarChangeListener { _, rating, fromUser ->
                if (fromUser) {
                    joke.rating = rating
                    onClick(joke)
                }
            }
        }

        fun bind(joke: Joke) {
            this.joke = joke
            jokeTextView.text = joke.content
            sourceTextView.text = joke.source
            ratingBar.rating = joke.rating
        }
    }

    class JokesComparator : DiffUtil.ItemCallback<Joke>() {
        override fun areItemsTheSame(oldItem: Joke, newItem: Joke): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Joke, newItem: Joke): Boolean {
            return oldItem.id == newItem.id
                    && oldItem.source == newItem.source
                    && oldItem.jokeId == newItem.jokeId
                    && oldItem.content == newItem.content
                    && oldItem.rating == newItem.rating
                    && oldItem.createdAt == newItem.createdAt
        }
    }
}