package com.example.librarytestapplication.view.api

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.librarytestapplication.R
import com.example.librarytestapplication.model.WikipediaList

class WikipediaListAdapter(private val context: Context) : RecyclerView.Adapter<WikipediaListAdapter.WikipediaListViewHolder>() {

    lateinit var view: View
    val wikipediaList: WikipediaList.Companion = WikipediaList

    class WikipediaListViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.wikipediaTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WikipediaListViewHolder {
        view = LayoutInflater.from(context).inflate(
            R.layout.wikipedia_list,
            parent,
            false
        )
        return WikipediaListViewHolder(view)

    }

    override fun getItemCount(): Int = WikipediaList.title.size

    override fun onBindViewHolder(holder: WikipediaListViewHolder, position: Int) {
        holder.title.text = wikipediaList.title[position]
//        holder.title.text = titleList[position].title
//
//        holder.title.setOnClickListener {
//            Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
//            functionIntent(position)
//
//        }

    }
//
//    fun functionIntent(position: Int){
//
//        val intent =
//            when(position){
//                0 -> Intent(context, APIActivity::class.java)
//                else -> Intent(context, MainActivity::class.java)
//            }
//
//        intent.putExtra(KeyStringUntils().MAIN_LIST_KEY, position)
//        context.startActivity(intent)
//    }


}