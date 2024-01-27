package com.csx4109.assignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.csx4109.assignment.R
import com.csx4109.assignment.databinding.GameItemGridBinding
import com.csx4109.assignment.models.Game

class GameGridAdapter(val context: Context, private val games:List<Game>): RecyclerView.Adapter<GameGridAdapter.GameGridViewHolder>() {
    class GameGridViewHolder(val binding: GameItemGridBinding):RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameGridViewHolder {
        val binding = GameItemGridBinding.inflate(LayoutInflater.from(context), parent, false)
        return GameGridViewHolder(binding)
    }

    override fun getItemCount(): Int = games.size

    override fun onBindViewHolder(holder: GameGridViewHolder, position: Int) {
        val game = games[position]

        holder.binding.ivGame.load(game.image) {
            placeholder(R.drawable.ic_launcher_background)
        }

        holder.binding.tvGameScore.text = game.rating.toString()
    }

}