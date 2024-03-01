package com.csx4109.assignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.csx4109.assignment.R
import com.csx4109.assignment.adapter.ListViewAdapter.RecycleViewHolder
import com.csx4109.assignment.models.Game

class ListViewAdapter( private val gameList: List<Game>): RecyclerView.Adapter<RecycleViewHolder>(){
        class RecycleViewHolder(val viewBinding: View): RecyclerView.ViewHolder(viewBinding){
                val gameName : TextView = itemView.findViewById(R.id.tvGameName)
                val gameRating : TextView = itemView.findViewById(R.id.tvGameScore)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.gameboarditem, parent, false)

                return RecycleViewHolder(itemView)
        }

        override fun getItemCount(): Int = gameList.size

        override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
                val game = gameList[position]

                holder.gameName.text = game.name
                holder.gameRating.text = game.rating.toString()
        }
}