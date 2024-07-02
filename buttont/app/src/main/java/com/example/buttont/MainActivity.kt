package com.example.buttont

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity

import androidx.activity.enableEdgeToEdge


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.layout)

        val down1 = findViewById<Button>(R.id.down5)
        down1.setOnClickListener {
            Toast.makeText(applicationContext,"Downloading...!", Toast.LENGTH_SHORT).show()
        }
    }
}

