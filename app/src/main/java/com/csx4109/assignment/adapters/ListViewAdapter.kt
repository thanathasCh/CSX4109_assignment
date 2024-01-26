package com.csx4109.assignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.csx4109.assignment.databinding.ListViewItemBinding
import com.csx4109.assignment.models.Game

class ListViewAdapter( private val game: List<Game>)
    :RecyclerView.Adapter<ListViewAdapter.ListViewHolder> () {
    class ListViewHolder(val binding: ListViewItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ListViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return game.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val game = game[position]
        holder.binding.tvGameName.text = game.name.toString()
        holder.binding.tvGenre.text = game.genre.toString()
        holder.binding.tvGameScore.text = game.rating.toString()
        holder.binding.tvGameDescription.text = game.description.toString()
        holder.binding.ivGame.load(game.image)
    }
}
