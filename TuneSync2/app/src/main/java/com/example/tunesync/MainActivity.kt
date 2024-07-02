package com.example.tunesync

import android.os.Bundle

import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tunesync.databinding.ActivityMainBinding
import com.example.tunesync.Model.categoryModel
import com.example.tunesync.Model.CategoryModel
import com.example.tunesync.Databinding
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

    private fun setUpCategoryRecyclerView(categoryList: List<CategoryModel>) {
        Log.d("Adapter", "Setting up adapter with ${categoryList.size} categories")
        categoryAdapter = CategoryAdapter1(categoryList)
        binding.catagoriesRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.catagoriesRecyclerView.adapter = categoryAdapter

        binding.categoriesRecyclerView1.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.categoriesRecyclerView1.adapter = categoryAdapter

        binding.categoriesRecyclerView2.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.categoriesRecyclerView2.adapter = categoryAdapter

        binding.categoriesRecyclerView3.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.categoriesRecyclerView3.adapter = categoryAdapter

        binding.categoriesRecyclerView4.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.categoriesRecyclerView4.adapter = categoryAdapter


    }
}