package com.csx4109.assignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.csx4109.assignment.databinding.GridItemBinding
import com.csx4109.assignment.models.Game
import com.squareup.picasso.Picasso

class GridAdapter(private val context: Context, private val game: List<Game>)
    : RecyclerView.Adapter<GridAdapter.ListHolder>(){

    class ListHolder(val binding: GridItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int = game.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding = GridItemBinding.inflate(layoutInflater, parent, false)

        return ListHolder(binding)
    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        val game = game[position]

        Picasso.get().load(game.image).into(holder.binding.ivGame)
        holder.binding.tvGameScore.text = game.rating.toString()
    }

}