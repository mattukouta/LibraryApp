package com.example.librarytestapplication.view.main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.librarytestapplication.R
import com.example.librarytestapplication.model.MainCell
import com.example.librarytestapplication.util.KeyStringUntils
import com.example.librarytestapplication.view.api.APIActivity



class MainListAdapter(private val context: Context, private val titleList : List<MainCell>) : RecyclerView.Adapter<MainListAdapter.MainListViewHolder>() {

    lateinit var view: View

    /**
     * recyclerViewのクリックイベントをActiviryで実装する場合
     */
//    lateinit var listener : View.OnClickListener

    class MainListViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.functionTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {
        view = LayoutInflater.from(context).inflate(
            R.layout.main_list,
            parent,
            false
        )
        return MainListViewHolder(view)

    }

    override fun getItemCount(): Int = titleList.size

    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
        holder.title.text = titleList[position].title

        holder.title.setOnClickListener {
            Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
            functionIntent(position)

        }

        /**
         * recyclerViewのクリックイベントをActiviryで実装する場合
         */
//        holder.title.setOnClickListener { view ->
//            listener.onClick(view)
//        }


    }

    /**
     * recyclerViewのクリックイベントをActiviryで実装する場合
     */
//    fun setOnItemClickListener(listener : View.OnClickListener){
//        this.listener = listener
//    }

    fun functionIntent(position: Int){

        val intent =
            when(position){
                0 -> Intent(context, APIActivity::class.java)
                else -> Intent(context, MainActivity::class.java)
            }

        intent.putExtra(KeyStringUntils().MAIN_LIST_KEY, position)
        context.startActivity(intent)
    }


}