package com.csx4109.assignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.csx4109.assignment.databinding.GridItemBinding
import com.csx4109.assignment.models.Game

class GridAdapter(private val context: Context, private val games: List<Game>) :
    RecyclerView.Adapter<GridAdapter.GameViewHolder>() {

    inner class GameViewHolder(private val binding: GridItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(game: Game) {
            with(binding) {
                ivGame.load(game.image)
                tvGameScore.text = game.rating.toString()
                root.setOnClickListener {
                    Toast.makeText(context, game.name, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val binding = GridItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GameViewHolder(binding)
    }

    override fun getItemCount(): Int = games.size

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bind(games[position])
    }
}
