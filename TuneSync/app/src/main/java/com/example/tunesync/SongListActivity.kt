package com.example.musicplayer

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.musicplayer.databinding.ActivitySongListBinding
import com.example.musicplayer.models.CategoryModel
import com.example.musicplayer.adapter.SongsAdapter as SongsAdapter1

class SongListActivity : AppCompatActivity() {
    companion object{
            lateinit var categoryModel: CategoryModel
    }
    private lateinit var binding:ActivitySongListBinding
    private lateinit var songsListAdapter : SongsAdapter1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySongListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nameTextView.text = categoryModel.name
        Glide.with(binding.coverImageView).load( categoryModel.coverUrl)
            .apply(
                RequestOptions().transform(RoundedCorners(32))
            )
            .into(binding.coverImageView)
        setUpSongsListRecyclerView()
    }
    private fun setUpSongsListRecyclerView(){
        songsListAdapter= SongsAdapter1(categoryModel.songs_playlist)
        binding.songsListRecylerView.layoutManager = LinearLayoutManager(this)
        binding.songsListRecylerView.adapter = songsListAdapter
    }
}
