package com.csx4109.assignment.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.csx4109.assignment.models.Game
import coil.load
import com.csx4109.assignment.databinding.GridItemBinding

class GridAdaptor(val context: Context, private val games: List<Game>)
    : RecyclerView.Adapter<GridAdaptor.GridViewHolder>() {

    class GridViewHolder(val view: GridItemBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val binding = GridItemBinding.inflate(LayoutInflater.from(context),parent,false)
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
