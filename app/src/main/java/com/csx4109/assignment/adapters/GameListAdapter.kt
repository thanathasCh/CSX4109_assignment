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

class GameListAdapter(private val games: List<Game>) : RecyclerView.Adapter<GameListAdapter.GameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_game_list, parent, false)
        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = games[position]
        holder.bind(game)
    }

    override fun getItemCount() = games.size

    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.ivGame)
        private val nameTextView: TextView = itemView.findViewById(R.id.tvGameName)
        private val genreTextView: TextView = itemView.findViewById(R.id.tvGenre)
        private val scoreTextView: TextView = itemView.findViewById(R.id.tvGameScore)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.tvGameDescription)

        fun bind(game: Game) {
            nameTextView.text = game.name
            genreTextView.text = game.genre
            scoreTextView.text = itemView.context.getString(R.string.game_score, game.rating)
            descriptionTextView.text = game.description
            imageView.load(game.image) {
                crossfade(true)
            }
        }
    }
}
