package com.example.tunesync.Adapter

import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tunesync.Model.songs_list
import com.example.tunesync.R
import com.example.tunesync.databinding.SongItemRecyclerRowBinding
import com.google.firebase.firestore.FirebaseFirestore

abstract class SongListAdapter (private val songIdList : List<String>) : RecyclerView.Adapter<SongListAdapter.MyViewHolder>(){


     class MyViewHolder(private val binding: SongItemRecyclerRowBinding) :
             RecyclerView.ViewHolder(binding.root) {
         fun bindData(songId: String) {
             FirebaseFirestore.getInstance().collection("song_playlist")
                 .document(songId).get()
                 .addOnSuccessListener {
                     val song = it.toObject(songs_list::class.java)
                     song?.apply {
                         binding.songTitleTextView.text = title
                         binding.songSubtitleTextView.text = subtitle
                         val RequestOption = null
                         Glide.with(binding.songCoverImageView).load(coverPageUrl)
                             .apply(
                                 RequestOPtions().transform(RoundedCorners(32))
                             )
                             .into(binding.songCoverImageView)


                     }
                 }

         }
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("Not yet implemented")
        val binding =
            SongItemRecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return MyViewHolder(binding)
    }




















}

