package com.example.newactivty

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class pament : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pament)


        val buttonsin = findViewById<Button>(R.id.button4)

        buttonsin.setOnClickListener {

            Toast.makeText(this,"Payment is Done", Toast.LENGTH_LONG).show()

        }
    }

        }

