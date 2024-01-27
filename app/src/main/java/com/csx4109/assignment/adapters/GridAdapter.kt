package com.csx4109.assignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.csx4109.assignment.databinding.ItemForGridBinding
import com.csx4109.assignment.models.Game
import com.squareup.picasso.Picasso

class GridAdapter(private val context: Context, private val games: List<Game>)
    : RecyclerView.Adapter<GridAdapter.ListHolder>() {

    class ListHolder(val binding: ItemForGridBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int = games.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding = ItemForGridBinding.inflate(layoutInflater, parent, false)
        return ListHolder(binding)
    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        val game = games[position]

        Picasso.get().load(game.image).into(holder.binding.ivGame)
        holder.binding.tvGameScore.text = game.rating.toString()
    }
}
