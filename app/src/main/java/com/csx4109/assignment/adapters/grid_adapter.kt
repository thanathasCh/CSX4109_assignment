package com.csx4109.assignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.csx4109.assignment.R
import com.csx4109.assignment.databinding.FragmentGridItemBinding
import com.csx4109.assignment.models.Game

class grid_adapter (val context: Context, private val games: List<Game>) : RecyclerView.Adapter<grid_adapter.GameGridViewHolder>() {
    class GameGridViewHolder(val binding: FragmentGridItemBinding):RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameGridViewHolder {
        val binding = FragmentGridItemBinding.inflate(LayoutInflater.from(context), parent, false)
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