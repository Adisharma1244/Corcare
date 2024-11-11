package com.example.newactivty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton

class labtest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_labtest)

        val signi = findViewById<FloatingActionButton>(R.id.floatingActionButton5)
        signi.setOnClickListener {
            val tent = Intent(this, bloodtest::class.java)
            startActivity(tent)

            val suger = findViewById<FloatingActionButton>(R.id.floatingActionButton6)
            suger.setOnClickListener {
                val tentt = Intent(this, SugartTest::class.java)
                startActivity(tentt)
            }
            val yray = findViewById<FloatingActionButton>(R.id.floatingActionButton4)
            yray.setOnClickListener {
                val tentt = Intent(this, Xray::class.java)
                startActivity(tentt)
            }
        }
}
}