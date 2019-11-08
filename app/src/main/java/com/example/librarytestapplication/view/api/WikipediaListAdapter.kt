package com.example.librarytestapplication.view.api

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.librarytestapplication.R
import com.example.librarytestapplication.model.WikipediaList

class WikipediaListAdapter(private val context: Context) : RecyclerView.Adapter<WikipediaListAdapter.WikipediaListViewHolder>() {

    lateinit var view: View
    val wikipediaList: WikipediaList.Companion = WikipediaList

    class WikipediaListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.wikipediaTitle)
        val body = view.findViewById<TextView>(R.id.wikipediaBody)
        val constraintLayout = view.findViewById<ConstraintLayout>(R.id.cell)
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
        holder.body.text = wikipediaList.body[position]

        holder.constraintLayout.setOnClickListener {
            /**
             * 押した部分のWikipediaページを表示
             */
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(wikipediaList.url[position]))
            context.startActivity(intent)
        }
    }
}
