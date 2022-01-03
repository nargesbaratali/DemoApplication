package com.example.demoapplication


import javax.inject.Inject

class Repository @Inject constructor(
    private val api: Api
) : SafeApiCall {
    suspend fun getEduTypes() = safeApiCall { api.getEduTypes() }
    suspend fun getNftSales() = safeApiCall { api.getNftSales() }

    suspend fun getData() = safeApiCall { api.getData() }



}