package com.example.librarytestapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainListAdapter(private val context: Context, private val titleList : List<MainCell>) : RecyclerView.Adapter<MainListAdapter.MainListViewHolder>() {

    class MainListViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.functionTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListAdapter.MainListViewHolder =
        MainListViewHolder(LayoutInflater.from(context).inflate(R.layout.main_list, parent, false))

    override fun getItemCount(): Int = titleList.size

    override fun onBindViewHolder(holder: MainListAdapter.MainListViewHolder, position: Int) {
        holder.title.text = titleList[position].title
    }


}