package com.csx4109.assignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.csx4109.assignment.databinding.GridViewFragmentBinding
import com.csx4109.assignment.models.Game

class GridAdapter(private val context: Context, private val games: List<Game>)
    : RecyclerView.Adapter<GridAdapter.RecyclerViewHolder>() {

    class RecyclerViewHolder(val binding: GridViewFragmentBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val binding = GridViewFragmentBinding.inflate(LayoutInflater.from(context), parent, false)

        return RecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int = games.size

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val gameScore = games[position]

        holder.binding.ivGame.load(gameScore.image)

        holder.binding.tvGameScore.text = gameScore.rating.toString()

    }
}