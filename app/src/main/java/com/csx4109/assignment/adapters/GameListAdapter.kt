package com.csx4109.assignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.csx4109.assignment.databinding.ItemGameListBinding
import com.csx4109.assignment.models.Game

class GameListAdapter(val context: Context, private val gamesList: List<Game>) : RecyclerView.Adapter<GameListAdapter.GameListViewHolder>() {
    class GameListViewHolder(val binding: ItemGameListBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameListViewHolder {
        val binding = ItemGameListBinding.inflate(LayoutInflater.from(context), parent, false)
        return GameListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GameListViewHolder, position: Int) {
        val game = gamesList[position]
        holder.binding.ivGame.load(
            game.image
        )
        holder.binding.tvGameName.text = game.name
        holder.binding.tvGenre.text = game.genre
        holder.binding.tvGameScore.text = game.rating.toString()
        holder.binding.tvGameDescription.text = game.description
    }

    override fun getItemCount(): Int = gamesList.size

}