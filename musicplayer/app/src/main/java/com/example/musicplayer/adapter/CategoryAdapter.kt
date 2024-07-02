package com.example.musicplayer.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.OptIn
import androidx.media3.common.util.Log
import androidx.media3.common.util.UnstableApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.*
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.musicplayer.databinding.CategoryItemRecyclerRowBinding
import com.example.musicplayer.models.CategoryModel

class CategoryAdapter(private val categoryList: List<CategoryModel>) : RecyclerView.Adapter<CategoryAdapter.MyViewHolder>(){
    class MyViewHolder(private val binding : CategoryItemRecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){
        //bind the data with views
        @OptIn(UnstableApi::class)
        fun bindData(categoryModel: CategoryModel){
            binding.nameTextView.text = categoryModel.name
            with(binding.coverImageView).load(categoryModel.coverUrl)
                .apply(
                    RequestOptions().transform(RoundedCorners(32))
                )
                .into(binding.coverImageView)
            Log.i("SONGS", categoryModel.songs_playlist.size.toString())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val binding = CategoryItemRecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(categoryList[position])
    }
}