package com.example.newactivty

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class appointment : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
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
        val appointment3 = findViewById<Button>(R.id.button7)
        appointment3.setOnClickListener {
            val tent = Intent(this, schedulepage::class.java)
            startActivity(tent)

        }
        val appointment4 = findViewById<Button>(R.id.button9)
        appointment4.setOnClickListener {
            val tent = Intent(this, schedulepage::class.java)
            startActivity(tent)
    }
        val appointment5 = findViewById<Button>(R.id.button10)
        appointment5.setOnClickListener {
            val tent = Intent(this, schedulepage::class.java)
            startActivity(tent)}
    }}