package com.example.inte_nt

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val intentt=findViewById<Button>(R.id.button4)
        intentt.setOnClickListener {
            Toast.makeText(applicationContext, "Detecting...", Toast.LENGTH_SHORT).show()
            intent= Intent(this,intent_t::class.java)
            startActivity(intent)
        }
    }
}