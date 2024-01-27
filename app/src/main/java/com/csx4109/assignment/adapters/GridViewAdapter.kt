package com.csx4109.assignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.Toast
import coil.load
import com.csx4109.assignment.databinding.GridViewItemBinding
import com.csx4109.assignment.models.Game

class GridViewAdapter(private val context: Context, private val games: List<Game>)
    : RecyclerView.Adapter<GridViewAdapter.GridViewHolder>() {
    class GridViewHolder(val view: GridViewItemBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val binding = GridViewItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return GridViewHolder(binding)
    }

    override fun getItemCount(): Int = games.size

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val game = games[position]

        holder.view.ivGame.load(game.image)
        holder.view.tvGameScore.text = game.rating.toString()
        holder.view.root.setOnClickListener {
            Toast.makeText(context, game.name, Toast.LENGTH_SHORT).show()
        }
    }
}