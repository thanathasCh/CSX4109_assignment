package com.csx4109.assignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.csx4109.assignment.databinding.ListItemBinding
import com.csx4109.assignment.models.game
import com.squareup.picasso.Picasso

class ListAdapter(private val context: Context, private val game: List<game>)
    : RecyclerView.Adapter<ListAdapter.ListHolder>(){
    class ListHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root)
    override fun getItemCount(): Int = game.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding = ListItemBinding.inflate(layoutInflater, parent, false)

        return ListHolder(binding)
    }
    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        val game = game[position]

        Picasso.get().load(game.image).into(holder.binding.ivGame)
        holder.binding.tvGameName.text = game.name
        holder.binding.tvGenre.text = game.genre
        holder.binding.tvGameDescription.text = game.description
        holder.binding.tvGameScore.text = game.rating.toString()
    }

}