package com.example.newactivty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen)

        Handler().postDelayed({
           val intent = Intent(this,UnityCare::class.java)
           startActivity(intent)
           finish() },2000)
    }
}