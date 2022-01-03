package com.example.demoapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapplication.databinding.EduTipBinding
import com.example.demoapplication.databinding.NftSaleBinding
import com.example.demoapplication.databinding.TopPostBinding

class HomeRecyclerViewAdapter : RecyclerView.Adapter<HomeRecyclerViewHolder>() {

    var items = listOf<HomeRecyclerViewItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerViewHolder {
        return when(viewType){
            R.layout.top_post -> HomeRecyclerViewHolder.TopPostViewHolder(
                TopPostBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            R.layout.edu_tip -> HomeRecyclerViewHolder.EduTypeViewHolder(
                EduTipBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            R.layout.nft_sale -> HomeRecyclerViewHolder.NftSaleViewHolder(
                NftSaleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }
    }

    override fun onBindViewHolder(holder: HomeRecyclerViewHolder, position: Int) {
        when(holder){
            is HomeRecyclerViewHolder.NftSaleViewHolder -> holder.bind(items[3] as HomeRecyclerViewItem.NftSale)
            is HomeRecyclerViewHolder.EduTypeViewHolder -> holder.bind(items[1] as HomeRecyclerViewItem.EduType)
            is HomeRecyclerViewHolder.TopPostViewHolder -> holder.bind(items[0] as HomeRecyclerViewItem.TopPost)
        }
    }

    override fun getItemCount() = items.size

//    override fun getItemViewType(position: Int): Int {
//        return when(items[0-5]){
//            is HomeRecyclerViewItem.NftSale -> R.layout.nft_sale
//            is HomeRecyclerViewItem.EduType -> R.layout.edu_tip
//            is HomeRecyclerViewItem.TopPost -> R.layout.top_post
//            else -> {
//                print("st")
//            }
//        }
//    }
}
