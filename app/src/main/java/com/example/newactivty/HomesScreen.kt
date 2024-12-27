package com.example.newactivty

import android.annotation.SuppressLint
import android.os.Handler
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2

class HomesScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homes_screen)


        val fbut = findViewById<FloatingActionButton>(R.id.floatingActionButtonn)
        fbut.setOnClickListener {
            val tent = Intent(this, precaution::class.java)
            startActivity(tent)
        }
        val pbutton = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        pbutton.setOnClickListener {
            val tentt = Intent(this, appointment::class.java)
            startActivity(tentt)
        }
        val fbutton = findViewById<FloatingActionButton>(R.id.floatingActionButton3)
        fbutton.setOnClickListener {
            val tentt = Intent(this, labtest::class.java)
            startActivity(tentt)
        }

//        val medi = findViewById<FloatingActionButton>(R.id.floatingActionButton7)
//        medi.setOnClickListener {
//            val tentt = Intent(this, medicens::class.java)
//            startActivity(tentt)
//        }
        val eme = findViewById<FloatingActionButton>(R.id.floatingActionButton2)
        eme.setOnClickListener {
            val tentt = Intent(this, emergency::class.java)
            startActivity(tentt)

        }
        val books = findViewById<FloatingActionButton>(R.id.floatingActionButton7)
        books.setOnClickListener {
            val tentt = Intent(this, bookedappointments::class.java)
            startActivity(tentt)

        }
    }
}







