package com.example.newactivty

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class fixappointment : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fixappointment)

        val message = intent.getStringExtra("Time")
        val dateText = intent.getStringExtra("date")
        val name = intent.getStringExtra("Name")

        findViewById<TextView>(R.id.textView10).apply {
            text = message
        }

        findViewById<TextView>(R.id.textView12).apply {
            text = dateText
        }
        findViewById<TextView>(R.id.textView2).apply {
            text = name
        }
        val signi = findViewById<Button>(R.id.button3)
        signi.setOnClickListener {
            val tent = Intent(this, pament::class.java)
            startActivity(tent)
        }

    }
}