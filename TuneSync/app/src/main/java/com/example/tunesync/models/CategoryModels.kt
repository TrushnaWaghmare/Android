package com.example.tunesync.models

data class CategoryModels(
    val name: String,
    val coverUrl: String,
    val songs_playlist: List<String>){
    constructor() : this( "","", listOf())


}