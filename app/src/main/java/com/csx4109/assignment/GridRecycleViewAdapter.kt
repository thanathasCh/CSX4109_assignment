package com.csx4109.assignment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.csx4109.assignment.databinding.ActivityGridViewBinding
import com.csx4109.assignment.models.Game

class GridRecyclerViewAdapter(private val context: Context, private val games: List<Game>)
    : RecyclerView.Adapter<GridRecyclerViewAdapter.GridViewHolder>() {

    class GridViewHolder(val binding: ActivityGridViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int = games.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding = ActivityGridViewBinding.inflate(layoutInflater, parent, false)

        return GridViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val game = games[position]
        holder.binding.tvGameScore.text = game.rating.toString()
        Glide.with(context)
            .load(game.image)
            .into(holder.binding.ivImage)
    }
}
