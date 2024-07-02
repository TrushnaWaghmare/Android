package com.example.splash

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.splash.adapter.CategoryAdapter
import com.example.splash.databinding.ActivityMainBinding
import com.example.splash.models.CategoryModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var categoryAdapter: CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getCategories()
    }
    private fun getCategories(){
        FirebaseFirestore.getInstance().collection("categories")
            .get().addOnSuccessListener {

                val categoryList = it.toObjects(categoryAdapter::class.java)
                setUpCategoryRecyclerView(categoryList)
            }


    }

    private fun setUpCategoryRecyclerView(categoryList: List<CategoryAdapter>){
        categoryAdapter = CategoryAdapter(categoryList)
        binding.


    }
}