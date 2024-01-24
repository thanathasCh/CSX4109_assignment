package com.csx4109.assignment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.csx4109.assignment.R
import com.csx4109.assignment.models.Game

class GameGridAdapter(private val games: List<Game>) : RecyclerView.Adapter<GameGridAdapter.GameGridViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameGridViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_game_grid, parent, false)
        return GameGridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameGridViewHolder, position: Int) {
        val game = games[position]
        holder.bind(game)
    }

    override fun getItemCount() = games.size

    inner class GameGridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.ivGame)
        private val scoreTextView: TextView = itemView.findViewById(R.id.tvGameScore)

        fun bind(game: Game) {
            scoreTextView.text = game.rating.toString()
            imageView.load(game.image) {
                crossfade(true)
            }
        }
    }
}
