package com.csx4109.assignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.csx4109.assignment.databinding.ItemGameGridBinding
import com.csx4109.assignment.models.Game

class GameGridAdapter(val context: Context, private val gamesList: List<Game>):RecyclerView.Adapter<GameGridAdapter.GameGridViewHolder>(){
    class GameGridViewHolder(val binding: ItemGameGridBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameGridViewHolder{
        val binding = ItemGameGridBinding.inflate(LayoutInflater.from(context), parent, false)
        return GameGridViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GameGridViewHolder, position: Int) {
        val game = gamesList[position]
        holder.binding.ivGame.load(
            game.image
        )
        holder.binding.tvGameScore.text = game.rating.toString()
    }

    override fun getItemCount(): Int = gamesList.size
}