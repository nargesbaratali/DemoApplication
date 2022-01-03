package com.example.demoapplication

import com.google.gson.annotations.SerializedName


sealed class HomeRecyclerViewItem {



    //topPost
    class TopPost(

        val feedType : String,
         val content : String,
         val createAt : Int,
         val dacAvatar : String,
         val dacName : String,
         val images : List<String>,
        val nickName : String,
         val video : String,
         val videoLength : Int,
         val videoThumbnail : String,
    val videoTopPost : String,
         val views : Int
        ) : HomeRecyclerViewItem()

    //eduTip
    class EduType(
        val feedType: String,
        val content: String,
        val contentType: String,
        val eduAvatar: String,
        val eduName: String,
        val title: String,
        val views: String
    ) : HomeRecyclerViewItem()

    //nftsale
    class NftSale(

        val feedType: String,
        val creator: Creator,
        val dacName: String,
        val editions: String,
        val media: Media,
        val name: String,
        val price: String,
        val releasedAt: Long,
        val type: String,
        val unit: String

    ) : HomeRecyclerViewItem()
//    companion object {
//        public fun fromJson(json: String) = klaxon.parse<NftSale>(json)
//    }
}

data class Creator (
    val avatar: String,
    val nickname: String,
    val username: String
)

data class Media (
    val audio: List<Any?>,
    val cover: String,
    val image: List<String>,
    val model: List<Any?>,
    val txt: List<Any?>,
    val video: List<Any?>
)


