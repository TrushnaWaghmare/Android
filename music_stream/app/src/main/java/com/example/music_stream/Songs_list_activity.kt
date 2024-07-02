package com.example.music_stream

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.music_stream.Adapter.SongListAdapter
import com.example.music_stream.Models.CategoryModel
import com.example.music_stream.databinding.ActivitySongsListBinding

class Songs_list_activity : AppCompatActivity() {

    companion object{
        lateinit var categoryModel: CategoryModel
    }

    private lateinit var binding: ActivitySongsListBinding
    lateinit var songsListAdapter: SongListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_songs_list)

        binding.nameTextView.text = categoryModel.name
        Glide.with(binding.coverImageView).load(categoryModel.coverUrl)

            .apply {
                RequestOptions().transform(RoundedCorners(32))

            }
            .into(binding.coverImageView)

        setupSongsListRecyclerView()
    }
    fun setupSongsListRecyclerView() {
        songsListAdapter = SongListAdapter(categoryModel.songs_playlist)
        binding.songsListRecylerView.layoutManager = LinearLayoutManager(this)
        binding.songsListRecylerView.adapter = songsListAdapter
    }
}