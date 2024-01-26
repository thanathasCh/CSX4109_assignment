package com.csx4109.assignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.csx4109.assignment.databinding.GridViewItemBinding
import com.csx4109.assignment.models.Game

class GridViewAdapter( private val game: List<Game>)
    :RecyclerView.Adapter<GridViewAdapter.GridViewHolder> () {
    class GridViewHolder(val binding: GridViewItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val binding = GridViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GridViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return game.size
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val game = game[position]
        holder.binding.tvGameScore.text = game.rating.toString()
        holder.binding.ivGame.load(game.image)
    }
}

