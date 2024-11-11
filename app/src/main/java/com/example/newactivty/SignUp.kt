package com.example.newactivty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.newactivty.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {
    // Use the correct binding class for your layout
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater) // Correct binding class
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.button.setOnClickListener {
            val email = binding.editTextText4.text.toString()
            val password = binding.editTextTextPassword.text.toString()
            val cpassword = binding.editTextTextPasswordd.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()&& cpassword.isNotEmpty()) {
                if(password == cpassword){
                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
                        if(it.isSuccessful){
                            val intent = Intent (this,UnityCare::class.java)
                            startActivity(intent)
                    }else{
                            Toast.makeText(this,it.exception.toString(), Toast.LENGTH_LONG).show()
                    }
                    }
                }else{
                    Toast.makeText(this,"Password is not matching", Toast.LENGTH_LONG).show()
                }
             }
            else{
                Toast.makeText(this,"Empty fields are not allowes ", Toast.LENGTH_LONG).show()
            }

        }
        }
    }

