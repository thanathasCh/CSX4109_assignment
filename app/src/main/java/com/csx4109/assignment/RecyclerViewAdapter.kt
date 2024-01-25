package com.csx4109.assignment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.csx4109.assignment.databinding.ActivityListViewBinding
import com.csx4109.assignment.models.Game


class RecyclerViewAdapter(private val context: Context, private val games: List<Game>)
    : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    class RecyclerViewHolder(val binding: ActivityListViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int = games.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding = ActivityListViewBinding.inflate(layoutInflater, parent, false)

        return RecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val game = games[position]
        holder.binding.tvGameName.text = game.name
        holder.binding.tvGameDescription.text = game.description
        holder.binding.tvGenre.text = game.genre
        holder.binding.tvGameScore.text = game.rating.toString()

        Glide.with(context)
            .load(game.image)
            .into(holder.binding.ivImage)
    }
}
