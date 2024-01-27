package com.csx4109.assignment.adapters
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.csx4109.assignment.R
import com.csx4109.assignment.databinding.ActivityGridViewBinding
import com.csx4109.assignment.models.Game

class GridViewAdapter(private val context: Context, private val games: List<Game>): RecyclerView.Adapter<GridViewAdapter.GridViewHolder>(){
    class GridViewHolder(val binding: ActivityGridViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int = games.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding = ActivityGridViewBinding.inflate(layoutInflater, parent, false)
        return GridViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val game = games[position]
        holder.binding.ivGame.load(game.image){
            placeholder(R.drawable.ic_launcher_background)
        }
        holder.binding.tvGameScore.text = game.rating.toString()




    }


}