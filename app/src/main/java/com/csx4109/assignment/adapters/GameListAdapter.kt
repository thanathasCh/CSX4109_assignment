package com.csx4109.assignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.csx4109.assignment.databinding.GameListItemBinding
import com.csx4109.assignment.models.Game

class GameListAdapter(private val games: List<Game>) :
    RecyclerView.Adapter<GameListAdapter.GameListViewHolder>() {
    class GameListViewHolder(val view: GameListItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameListViewHolder {
        val binding =
            GameListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return GameListViewHolder(binding)
    }

    override fun getItemCount(): Int = games.size

    override fun onBindViewHolder(holder: GameListViewHolder, position: Int) {
        val game = games[position]

        holder.view.tvGameName.text = game.name
        holder.view.tvGenre.text = game.genre
        holder.view.tvGameDescription.text = game.description
        holder.view.tvGameScore.text = game.rating.toString()
        holder.view.ivGame.load(game.image)
    }
}