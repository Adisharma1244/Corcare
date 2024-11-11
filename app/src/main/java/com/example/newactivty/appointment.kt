package com.example.newactivty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class appointment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment)

        val appointment1 = findViewById<Button>(R.id.button1)
        appointment1.setOnClickListener {
            val tent = Intent(this, schedulepage::class.java)
            startActivity(tent)
        }
        val appointment2 = findViewById<Button>(R.id.button2)
        appointment2.setOnClickListener {
            val tent = Intent(this, schedulepage::class.java)
            startActivity(tent)

        }

    }
}