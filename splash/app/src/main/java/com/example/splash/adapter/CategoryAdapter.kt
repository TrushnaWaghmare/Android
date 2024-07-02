package com.example.splash.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.splash.databinding.CategoryItemRecyclerRowBinding
import com.example.splash.models.CategoryModel

class CategoryAdapter (private val categoryList:List<):RecyclerView.Adapter<CategoryAdapter.MyViewHolder>()
{
    class MyViewHolder(private val binding: CategoryItemRecyclerRowBinding): RecyclerView.ViewHolder(binding.root){

        fun bindData(CategoryModel:){
            binding.nameTextView.text = categoryModel.name

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = CategoryItemRecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(categoryList[position])

    }

}