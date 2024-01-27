package com.csx4109.assignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.csx4109.assignment.databinding.GameGridItemBinding
import com.csx4109.assignment.models.Game

class GridAdapter(private val context: Context, private val games: List<Game>) :
    RecyclerView.Adapter<GridAdapter.GameGridViewHolder>() {
    class GameGridViewHolder(val view: GameGridItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameGridViewHolder {
        val binding =
            GameGridItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return GameGridViewHolder(binding)
    }

    override fun getItemCount(): Int = games.size

    override fun onBindViewHolder(holder: GameGridViewHolder, position: Int) {
        val game = games[position]

        holder.view.ivGame.load(game.image)
        holder.view.tvGameScore.text = game.rating.toString()

        holder.view.root.setOnClickListener {
            Toast.makeText(context, game.name, Toast.LENGTH_SHORT).show()
        }
    }
}