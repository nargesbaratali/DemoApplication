package com.example.demoapplication

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.demoapplication.databinding.EduTipBinding
import com.example.demoapplication.databinding.NftSaleBinding
import com.example.demoapplication.databinding.TopPostBinding

sealed class HomeRecyclerViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class TopPostViewHolder(private val binding: TopPostBinding) : HomeRecyclerViewHolder(binding){
        fun bind(TopPost: DataModel){
            binding.textViewTopPost.text = TopPost.feedType
        }
    }

    class EduTypeViewHolder(private val binding: EduTipBinding) : HomeRecyclerViewHolder(binding){
        fun bind(EduType: DataModel){

            binding.edutipTitle.text = EduType.content

            //  binding.imageViewEduType.loadImage(EduType.)
        }
    }

    class NftSaleViewHolder(private val binding: NftSaleBinding) : HomeRecyclerViewHolder(binding){
        @SuppressLint("StringFormatInvalid")
        fun bind(NftSale: DataModel){
           // binding.imageViewNftSale.loadImage(NftSale.)
            binding.textViewName.text = NftSale.dacName
          //  binding.textViewEduTypes.text = binding.textViewEduTypes.context.getString(R.string.total_EduTypes, NftSale.EduType_count)
        }
    }
}