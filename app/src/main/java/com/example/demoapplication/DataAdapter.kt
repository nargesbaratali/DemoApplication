package com.example.demoapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdpter(public var dataList: List<DataModel>, private val context: Context) : RecyclerView.Adapter<DataAdpter.ViewHolder>() {

    var items = listOf<DataModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.top_post, parent, false))


    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = dataList.get(position)

        holder.titleTextView.text = dataModel.nickName
    }


    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        lateinit var titleTextView: TextView
        public lateinit var dataList: List<DataModel>

        init {

            titleTextView = itemLayoutView.findViewById(R.id.title)
            titleTextView.text= dataList.get(0).feedType


        }

    }
}