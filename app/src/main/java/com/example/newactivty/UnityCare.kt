package com.example.newactivty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.newactivty.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class UnityCare : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val signi = findViewById<Button>(R.id.button3)

        firebaseAuth =FirebaseAuth.getInstance()
        binding.buttonn.setOnClickListener {
        val intent = Intent (this,SignUp::class.java)
        startActivity(intent)}

        binding.button.setOnClickListener {
            val email = binding.editTextText6.text.toString()
            val password = binding.editTextTextPassord.text.toString()


            if (email.isNotEmpty() && password.isNotEmpty()) {
                    firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener{
                        if(it.isSuccessful){
                            val intent = Intent (this,HomesScreen::class.java)
                            startActivity(intent)
                        }}
                }

            else{
                Toast.makeText(this,"Empty fields are not allowes ", Toast.LENGTH_LONG).show()
            }

        }
    }
    }



