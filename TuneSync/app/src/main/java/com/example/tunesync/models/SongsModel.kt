package com.example.tunesync.models

data class SongsModel(
    val id:String,
    val title: String,
    val subtitle : String,
    val url:String,
    val coverPageUrl : String
){
    constructor(): this(" "," ", " " ," ","")
}
