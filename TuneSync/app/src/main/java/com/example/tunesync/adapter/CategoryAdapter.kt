package com.example.tunesync.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.tunesync.models.CategoryModels
import com.example.tunesync.adapter.CategoryAdapter

class CategoryAdapter (private val categoryList: List<CategoryModels>) : RecyclerView.Adapter<CategoryAdapter.MyViewHolder>(){
    class MyViewHolder(private val binding : CategoryItemRecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }
}