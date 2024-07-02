package com.example.music_stream.Models

data class CategoryModel(
    val name : String ,
    val coverUrl : String ,
    val songs_playlist : List<String>
) {
    constructor() : this("","", listOf())
}
