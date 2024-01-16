package com.csx4109.assignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.csx4109.assignment.R
import com.csx4109.assignment.databinding.GameItemListBinding
import com.csx4109.assignment.models.Game

class GameListAdapter(val context: Context, private val games: List<Game>) : RecyclerView.Adapter<GameListAdapter.GameListViewHolder>() {
    class GameListViewHolder(val binding: GameItemListBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameListViewHolder {
        val binding = GameItemListBinding.inflate(LayoutInflater.from(context), parent, false)
        return GameListViewHolder(binding)
    }

    override fun getItemCount(): Int = games.size

    override fun onBindViewHolder(holder: GameListViewHolder, position: Int) {
        val game = games[position]

        holder.binding.ivGame.load(game.image) {
            placeholder(R.drawable.ic_launcher_background)
        }
        holder.binding.tvGameName.text = game.name
        holder.binding.tvGenre.text = game.genre
        holder.binding.tvGameScore.text = game.rating.toString()
        holder.binding.tvGameDescription.text = game.description
    }

}