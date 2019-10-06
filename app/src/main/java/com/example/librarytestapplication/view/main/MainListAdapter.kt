package com.example.librarytestapplication.view.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.librarytestapplication.R
import com.example.librarytestapplication.model.MainCell
import com.example.librarytestapplication.util.KeyStringUntils

class MainListAdapter(private val context: Context, private val titleList : List<MainCell>) : RecyclerView.Adapter<MainListAdapter.MainListViewHolder>() {

    lateinit var view: MainListViewHolder

    class MainListViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.functionTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {
        view = MainListViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.main_list,
                    parent,
                    false
                )
            )
        return view

    }

    override fun getItemCount(): Int = titleList.size

    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
        holder.title.text = titleList[position].title

        holder.title.setOnClickListener {
            Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
            functionIntent(position)
        }


    }

    fun functionIntent(position: Int){

        val intent =
            when(position){
                0 -> Intent(context, MainActivity::class.java)
                else -> Intent(context, MainActivity::class.java)
            }

        val bundle = Bundle()

        bundle.putInt(KeyStringUntils().MAIN_LIST_KEY, position)

        startActivity(context, intent, bundle)
    }


}