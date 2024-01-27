package com.csx4109.assignment.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.csx4109.assignment.databinding.GameboarditemBinding
import com.csx4109.assignment.models.Game

class LinearLayout(private val context: Context, private val gameList: List<Game>) : BaseAdapter() {

    private class GameBoardViewHolder(val viewBinding: GameboarditemBinding){
        val tvGameGenere = viewBinding.tvGenere
        val tvGameName = viewBinding.tvGameName
        val tvGameScore = viewBinding.tvGameScore
        val tvGameDescription = viewBinding.tvGameDescription
    }
    override fun getCount(): Int = gameList.size
    override fun getItem(position: Int): Game = gameList[position]

    override fun getItemId(position: Int): Long = position.toLong()
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View
        val viewHolder: GameBoardViewHolder

        if(convertView == null){
            Log.d("WAT", "convertView is null: $position")
            val binding =
                GameboarditemBinding.inflate(LayoutInflater.from(context), parent, false)
            view = binding.root
            viewHolder = GameBoardViewHolder(binding)
            view.tag=viewHolder
        }
        else{
            view = convertView
            viewHolder = convertView.tag as GameBoardViewHolder
        }
        viewHolder.tvGameGenere.text = getItem(position).genre
        viewHolder.tvGameName.text = getItem(position).name
        viewHolder.tvGameDescription.text = getItem(position).description
        viewHolder.tvGameScore.text = getItem(position).rating.toString()

        return view
    }

}