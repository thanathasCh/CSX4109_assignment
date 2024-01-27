package com.csx4109.assignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.csx4109.assignment.databinding.ItemListViewBinding
import com.csx4109.assignment.models.Game

class ListAdapter(private val games: List<Game>)
    : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    class ListViewHolder(val view: ItemListViewBinding ) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            ItemListViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = games.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val game = games[position]

        holder.view.tvGameName.text = game.name
        holder.view.tvGenre.text = game.genre
        holder.view.tvGameDescription.text = game.description
        holder.view.tvGameScore.text = game.rating.toString()
        holder.view.ivGame.load(game.image)
    }
}