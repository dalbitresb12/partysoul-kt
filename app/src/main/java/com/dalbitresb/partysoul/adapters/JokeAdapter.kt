package com.dalbitresb.partysoul.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dalbitresb.partysoul.R
import com.dalbitresb.partysoul.models.Joke

class JokeAdapter : ListAdapter<Joke, JokeAdapter.ViewHolder>(JokesComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

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

        companion object {
            fun create(parent: ViewGroup): ViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.joke_item, parent, false)
                return ViewHolder(view)
            }
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