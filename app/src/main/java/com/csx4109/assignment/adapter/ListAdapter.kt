package com.csx4109.assignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.csx4109.assignment.databinding.ListItemBinding
import com.csx4109.assignment.models.Game

class ListAdapter(private val games: List<Game>) :
    RecyclerView.Adapter<ListAdapter.GameViewHolder>() {

    inner class GameViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(game: Game) {
            with(binding) {
                tvGameName.text = game.name
                tvGenre.text = game.genre
                tvGameDescription.text = game.description
                tvGameScore.text = game.rating.toString()
                ivGame.load(game.image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = GameViewHolder(
        ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = games.size

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bind(games[position])
    }
}
