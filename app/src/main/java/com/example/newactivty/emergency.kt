package com.example.newactivty

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.floatingactionbutton.FloatingActionButton

class emergency : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency)

        val public = findViewById<FloatingActionButton>(R.id.floatingActionButton9)
        val closeoness = findViewById<FloatingActionButton>(R.id.floatingActionButton10)
        val newemergency = findViewById<FloatingActionButton>(R.id.floatingActionButton1)
        val emergencycall = findViewById<FloatingActionButton>(R.id.floatingActionButton11)
        val numberss = "8859601822"
        val Ambu = "108"
        val emergency = "112"
        val closeones = "8126700487"



        public.setOnClickListener {
            val num = Ambu  // Directly use the string value
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$num")
            startActivity(callIntent)
        }

        closeoness.setOnClickListener {
            val persons = closeones  // Directly use the string value
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$persons")
            startActivity(callIntent)
        }
        newemergency.setOnClickListener {
            val newemergency = numberss  // Directly use the string value
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$newemergency")
            startActivity(callIntent)
        }

        emergencycall.setOnClickListener {
            val emergencycalls = emergency   // Directly use the string value
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:$emergency")
            startActivity(callIntent)
        }
    }

}


