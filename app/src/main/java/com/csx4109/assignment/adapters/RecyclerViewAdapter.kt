package com.csx4109.assignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.csx4109.assignment.databinding.ListViewFragmentBinding
import com.csx4109.assignment.models.Game
import coil.load


class RecyclerViewAdapter(private val context: Context, private val games: List<Game>)
    : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    class RecyclerViewHolder(val binding: ListViewFragmentBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val binding = ListViewFragmentBinding.inflate(LayoutInflater.from(context), parent, false)

        return RecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int = games.size

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val gameScore = games[position]

        holder.binding.ivGame.load(gameScore.image)

        holder.binding.tvGameName.text = gameScore.name
        holder.binding.tvGenre.text = gameScore.genre
        holder.binding.tvGameScore.text = gameScore.rating.toString()
        holder.binding.tvGameDescription.text = gameScore.description

    }
}