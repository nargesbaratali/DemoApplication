package com.example.demoapplication


import com.example.demoapplication.HomeRecyclerViewItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @GET("")
    suspend fun getEduTypes(): List<HomeRecyclerViewItem.EduType>

    @GET("")
    suspend fun getNftSales(): List<HomeRecyclerViewItem.NftSale>


    @GET(" ")
    fun getData(): Call<List<HomeRecyclerViewItem>>
}


