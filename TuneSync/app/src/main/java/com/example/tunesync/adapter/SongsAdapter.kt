package com.example.tunesync.adapter

import android.content.Intent
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.musicplayer.PlayerActivity
import com.google.firebase.firestore.FirebaseFirestore

class SongsAdapter (private val SongIdList:List<String>): RecyclerView.Adapter<SongsAdapter.MyViewHolder>(){

    class MyViewHolder(private val binding: SongItemRecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun binData(songId: String) {
            FirebaseFirestore.getInstance().collection("songs_playlist")
                .document(songId).get()
                .addOnSuccessListener {
                    val song = it.toObject(SongsModel::class.java)
                    song?.apply {
                        binding.songNameTextView.text = title
                        binding.subTitleNameTextView.text = subtitle
                        Glide.with(binding.songCoverImageView).load(coverPageUrl)
                            .apply(
                                RequestOptions().transform(RoundedCorners(32))
                            )
                            .into(binding.songCoverImageView)

                        binding.root.setOnClickListener {
                            MyExoplayer.startPlaying(binding.root.context, song)

                            binding.root.setOnClickListener {
                                MyExoplayer.startPlaying(binding.root.context,song)
                                it.context.startActivity(Intent(it.context, PlayerActivity::class.java))
                            }

                        }
                    }
                }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}