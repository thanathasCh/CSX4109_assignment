package com.csx4109.assignment.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.csx4109.assignment.R
import com.csx4109.assignment.databinding.ItemGridBinding
import com.csx4109.assignment.models.Game

class GridAdapter(val context: Context, private val games: List<Game>): RecyclerView.Adapter<GridAdapter.GridViewHolder>() {
    class GridViewHolder(val binding: ItemGridBinding):RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val binding = ItemGridBinding.inflate(LayoutInflater.from(context), parent, false)

        return GridViewHolder(binding)
    }

    override fun getItemCount(): Int = games.size

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val game = games[position]

        holder.binding.ivGame.load(game.image) {
            placeholder(R.drawable.ic_launcher_background)
        }

        holder.binding.tvGameScore.text = game.rating.toString()
    }
}

