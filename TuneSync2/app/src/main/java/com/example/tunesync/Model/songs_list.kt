package com.example.tunesync.Model

data class songs_list(
    val id : String,
    val title : String,
    val subtitle : String,
    val url : String,
    val coverPageUrl : String,
){
    constructor() : this(" ","","","","")
}
