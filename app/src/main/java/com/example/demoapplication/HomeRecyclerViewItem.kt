package com.example.demoapplication

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


 open class HomeRecyclerViewItem {



     @Expose
     @SerializedName("feedType") val feedType : String = ""
     @SerializedName("content") val content : String = ""
     @SerializedName("createAt") val createAt : Int = 0
     @SerializedName("dacAvatar") val dacAvatar : String = ""
     @SerializedName("dacName") val dacName : String = ""
     @SerializedName("images") val images : List<String> = listOf("")
     @SerializedName("nickName") val nickName : String = ""
     @SerializedName("video") val video : String = ""
     @SerializedName("videoLength") val videoLength : Int = 0
     @SerializedName("videoThumbnail") val videoThumbnail : String = ""
     @SerializedName("videoTitle") val videoTitle : String = ""
     @SerializedName("views") val views : Int = 0

     //topPost
    class TopPost(


         val videoTopPost : String,
        ) : HomeRecyclerViewItem()

    //eduTip
    class EduType(
        val contentType: String,
        val eduAvatar: String,
        val eduName: String,
        val title: String,
    ) : HomeRecyclerViewItem()

    //nftsale
    class NftSale(

        val creator: Creator,
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


