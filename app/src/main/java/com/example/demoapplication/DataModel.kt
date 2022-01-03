package com.example.demoapplication

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataModel (
    @Expose
    @SerializedName("feedType") val feedType : String,
    @SerializedName("content") val content : String,
    @SerializedName("createAt") val createAt : Int,
    @SerializedName("dacAvatar") val dacAvatar : String,
    @SerializedName("dacName") val dacName : String,
    @SerializedName("images") val images : List<String>,
    @SerializedName("nickName") val nickName : String,
    @SerializedName("video") val video : String,
    @SerializedName("videoLength") val videoLength : Int,
    @SerializedName("videoThumbnail") val videoThumbnail : String,
    @SerializedName("videoTitle") val videoTitle : String,
    @SerializedName("views") val views : Int
        )