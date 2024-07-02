package com.example.musicplayer

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicplayer.adapter.CategoryAdapter
import com.example.musicplayer.databinding.ActivityMainBinding
import com.example.musicplayer.models.CategoryModel
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var categoryAdapter: CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getCategories()

    }

    private fun getCategories(){
        FirebaseFirestore.getInstance().collection("catagories")
            .get().addOnSuccessListener {
                val categoryList = it.toObjects(CategoryModel::class.java)
                setUpCategoryRecyclerView(categoryList)
            }

    }

    private fun setUpCategoryRecyclerView(categoryList: List<CategoryModel>){
        Log.d("Adapter", "Setting up adapter with ${categoryList.size} categories")
        categoryAdapter = CategoryAdapter(categoryList)
        binding.catagoriesRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.catagoriesRecyclerView.adapter = categoryAdapter

    }
}