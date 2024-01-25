package com.example.myapplication.framentexample.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ListViewItemBinding
import com.example.myapplication.framentexample.models.UserScore

class RecyclerViewAdapter(private val context: Context, private val score: List<UserScore>)
    : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>(){

    class RecyclerViewHolder(val binding: ListViewItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int = score.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding = ListViewItemBinding.inflate(layoutInflater, parent, false)

        return RecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val score = score[position]

        holder.binding.tvUserId.text = score.userId.toString()
        holder.binding.tvUserName.text = score.userName
        holder.binding.tvScore.text = score.score.toString()
    }
}