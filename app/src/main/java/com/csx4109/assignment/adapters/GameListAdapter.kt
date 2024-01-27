package com.csx4109.assignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.csx4109.assignment.databinding.GameItemLayoutBinding
import com.csx4109.assignment.models.Game

class GameListAdapter(
    private val context: Context,
    private val games: List<Game>
) : RecyclerView.Adapter<GameListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GameItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val game = games[position]
        holder.bind(game)
    }

    override fun getItemCount(): Int {
        return games.size
    }

    inner class ViewHolder(private val binding: GameItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(game: Game) {
            binding.apply {
                ivGame.load(game.image)
                tvGameName.text = game.name
                tvGenre.text = game.genre
                tvGameScore.text = game.rating.toString()
                tvGameDescription.text = game.description
            }
        }
    }
}