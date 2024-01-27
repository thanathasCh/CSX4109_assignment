package com.csx4109.assignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.csx4109.assignment.databinding.ListItemBinding
import com.csx4109.assignment.models.Game
import coil.load

class ListAdapter(private val games: List<Game>)
    :RecyclerView.Adapter<ListAdapter.listViewHolder>(){
    class listViewHolder(val view: ListItemBinding):RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listViewHolder {
       val binding =
           ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return listViewHolder(binding)
    }

    override fun getItemCount(): Int = games.size

    override fun onBindViewHolder(holder: listViewHolder, position: Int) {
        val game = games[position]

        holder.view.tvGameName.text = game.name
        holder.view.tvGenre.text = game.genre
        holder.view.tvGameDiscription.text = game.description
        holder.view.tvGameScore.text =game.rating.toString()
        holder.view.ivGame.load(game.image)
    }
}