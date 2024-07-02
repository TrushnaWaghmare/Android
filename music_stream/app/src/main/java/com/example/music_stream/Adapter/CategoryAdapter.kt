package com.example.music_stream.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.OptIn
import androidx.media3.common.util.Log
import androidx.media3.common.util.UnstableApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.music_stream.Models.CategoryModel
import com.example.music_stream.Songs_list_activity
import com.example.music_stream.databinding.CategoryItemRecyclerRowBinding

class CategoryAdapter(private val categoryList: List<CategoryModel>) : RecyclerView.Adapter<CategoryAdapter.MyViewHolder>(){
    class MyViewHolder(private val binding : CategoryItemRecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){
        //bind the data with views
        @OptIn(UnstableApi::class)
        fun bindData(categoryModel: CategoryModel){
            binding.textview.text = categoryModel.name

             Glide.with(binding.coverImageView).load(categoryModel.coverUrl)

                .apply {
                    RequestOptions().transform(RoundedCorners(32))

                }
                .into(binding.coverImageView)
            Log.i("SONGS", categoryModel.songs_playlist.size.toString())

            val context = binding.root.context
            binding.root.setOnClickListener {
                Songs_list_activity.categoryModel = categoryModel
                context.startActivity(Intent(context,Songs_list_activity::class.java))
            }
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